package com.ntt.department;

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
import com.ntt.common.GenericController;
import com.ntt.model.Department;

@Controller
public class DepartmentController extends GenericController<Department,Integer> {
	
	    private ApplicationRepository<Department, Integer> repo;
	    @Autowired
        private ProjectionFactory factory;
        @Autowired
	    private PagedResourcesAssembler<DeptRecords> assembler;
	
		@Autowired
		public DepartmentController(DeptRepo repo)
		{
			super(repo);
		}
		
		@GetMapping("/departments/search")
	    @ResponseBody
	    public ResponseEntity<?> findAllByAdvPredicate(@RequestParam(value="advsearch") String search,Pageable pageable) {
	    Page<Department> empl;
	    if (search != null && !search.isEmpty()) 
	    {
		Specification<Department> spec = resolveSpecificationFromInfixExpr(search);
	    empl =repo.findAll(spec,pageable);
	    }
	    else
	    {
	    empl =repo.findAll(pageable);
	    }
	    Page<DeptRecords> projected = empl.map(l -> factory.createProjection(DeptRecords.class, l));
	    PagedResources<Resource<DeptRecords>> resources = assembler.toResource(projected);
	    return ResponseEntity.ok(resources);
		}
}
