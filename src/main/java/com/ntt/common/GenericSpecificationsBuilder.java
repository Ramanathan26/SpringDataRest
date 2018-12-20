package com.ntt.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecificationsBuilder<T> {
    private final List<SpecSearchCriteria> params;

    public GenericSpecificationsBuilder() {
        this.params = new ArrayList<>();
    }

    public final GenericSpecificationsBuilder<T> with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

	public final GenericSpecificationsBuilder<T> with(final String precedenceIndicator, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) // the operation may be complex operation
            {
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SpecSearchCriteria(precedenceIndicator, key, op, value));
        }
        return this;
    }

    public Specification<T> build(Function<SpecSearchCriteria, Specification<T>> converter) {

        if (params.size() == 0) {
            return null;
        }

        final List<Specification<T>> specs = params.stream()
            .map(converter)
            .collect(Collectors.toCollection(ArrayList::new));

        Specification<T> result = specs.get(0);

        for (int idx = 1; idx < specs.size(); idx++) {
            result = params.get(idx)
                .isOrPredicate()
                    ? Specification.where(result)
                        .or(specs.get(idx))
                    : Specification.where(result)
                        .and(specs.get(idx));
        }
        
        return result;
    }

    public Specification<T> build(Deque<?> postFixedExprStack, Function<SpecSearchCriteria, Specification<T>> converter) {

        Deque<Specification<T>> specStack = new LinkedList<>();

        Collections.reverse((List<?>) postFixedExprStack);

        while (!postFixedExprStack.isEmpty()) {
            Object mayBeOperand = postFixedExprStack.pop();

            if (!(mayBeOperand instanceof String)) {
                specStack.push(converter.apply((SpecSearchCriteria) mayBeOperand));
            } else {
                Specification<T> operand1 = specStack.pop();
                Specification<T> operand2 = specStack.pop();
                if (mayBeOperand.equals(SearchOperation.AND_OPERATOR))
                    specStack.push(Specification.where(operand1)
                        .and(operand2));
                else if (mayBeOperand.equals(SearchOperation.OR_OPERATOR))
                    specStack.push(Specification.where(operand1)
                        .or(operand2));
            }

        }
        return specStack.pop();

    }
}
