package com.example.demo;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Projection(name="deptrecords",types={Department.class})
public interface DeptRecords {

	int getDeptid();
	EmpRecords2 getDeptheadid();
	String getDeptname();
}
