package com.ntt.common;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ntt.employee.EmpRecords;
import com.ntt.employee.EmplRepo;
import com.ntt.model.Employee;

public abstract class GenericController<T,ID extends Serializable> {
	
        private ApplicationRepository<T, ID> repo;

	    private final Logger log = LoggerFactory.getLogger(getClass());

	    public GenericController(ApplicationRepository<T, ID> repo) {
	        this.repo = repo;
	    }
	    protected Logger getLogger() {
	        return log;
	    }
	    protected Specification<T> resolveSpecificationFromInfixExpr(String searchParameters) {
	        CriteriaParser parser = new CriteriaParser();
	        GenericSpecificationsBuilder<T> specBuilder = new GenericSpecificationsBuilder<>();
	        return specBuilder.build(parser.parse(searchParameters), BaseGenericSpecification::new);
	    }
	    
	    protected Page<T> findAllByAdvPredicate(Pageable pageable, String search) {
	    	
	        if (search != null && !search.isEmpty()) {
	            Specification<T> spec = resolveSpecificationFromInfixExpr(search);
	            Page<T> data = repo.findAll(spec, pageable);
	            return data;
	        } else {
	            Page<T> data = repo.findAll(pageable);
	            return data;
	        }
	    
	    
	    }
}
