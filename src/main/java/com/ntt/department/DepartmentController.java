package com.ntt.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ntt.common.GenericController;
import com.ntt.model.Department;

@Controller
public class DepartmentController extends GenericController<Department,Integer> {
	
		@Autowired
		public DepartmentController(DeptRepo repo)
		{
			super(repo);
		}
		
}
