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
	    @Autowired
	    private ProjectionFactory factory;
	    @Autowired
		private PagedResourcesAssembler<EmpRecords> assembler;

	    private final Logger log = LoggerFactory.getLogger(getClass());

	    public GenericController(ApplicationRepository<T, ID> repo) {
	        this.repo = repo;
	    }
	    protected Logger getLogger() {
	        return log;
	    }

	    @GetMapping("/employees/search")
	    @ResponseBody
	    public ResponseEntity<?> findAllByAdvPredicate(@RequestParam(value="advsearch") String search,Pageable pageable) {
	        Specification<Employee> spec = resolveSpecificationFromInfixExpr(search);
	        Page<Employee> empl =repo.findAll(spec,pageable);
	        Page<EmpRecords> projected = empl.map(l -> factory.createProjection(EmpRecords.class, l));
	        PagedResources<Resource<EmpRecords>> resources = assembler.toResource(projected);
	        return ResponseEntity.ok(resources);
	    }
	     
	    protected Specification<Employee> resolveSpecificationFromInfixExpr(String searchParameters) {
	        CriteriaParser parser = new CriteriaParser();
	        GenericSpecificationsBuilder<Employee> specBuilder = new GenericSpecificationsBuilder<>();
	        return specBuilder.build(parser.parse(searchParameters), BaseGenericSpecification<Employee>::new);
	     
	    }
	
}
