package com.ntt.employee;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.ntt.common.BaseGenericSpecification;
import com.ntt.common.CriteriaParser;
import com.ntt.common.GenericController;
import com.ntt.common.GenericSpecificationsBuilder;
import com.ntt.model.Employee;

@Controller
public class EmployeeController extends GenericController<Employee,Integer>
{

	@Autowired
	public EmployeeController(EmplRepo repo)
	{
		super(repo);
	}
	
}