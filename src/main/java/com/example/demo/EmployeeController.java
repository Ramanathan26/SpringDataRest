package com.example.demo;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.google.common.base.Joiner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmployeeController 
{
	    @Autowired
	    private EmplRepo repo;
	    @Autowired
	    private ProjectionFactory factory;
	    @Autowired
		private PagedResourcesAssembler<EmpRecords> assembler;

	 
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
	        return specBuilder.build(parser.parse(searchParameters), EmployeeSpecification::new);
	       
	    }
	    }