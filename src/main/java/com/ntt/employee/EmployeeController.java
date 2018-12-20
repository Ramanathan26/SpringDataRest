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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ntt.common.ApplicationRepository;
import com.ntt.common.BaseGenericSpecification;
import com.ntt.common.CriteriaParser;
import com.ntt.common.GenericController;
import com.ntt.common.GenericSpecificationsBuilder;
import com.ntt.model.Employee;

@Controller
public class EmployeeController extends GenericController<Employee,Integer>
{

	private ApplicationRepository<Employee, Integer> repo;
	@Autowired
    private ProjectionFactory factory;
    @Autowired
	private PagedResourcesAssembler<EmpRecords> assembler;
	@Autowired
	public EmployeeController(EmplRepo repo)
	{
		super(repo);
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
   
   
}