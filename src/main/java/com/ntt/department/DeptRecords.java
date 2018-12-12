package com.ntt.department;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ntt.employee.EmpRecords2;
import com.ntt.model.Department;
import com.ntt.model.Employee;

@Projection(name="deptrecords",types={Department.class})
public interface DeptRecords {

	int getDeptid();
	EmpRecords2 getDeptheadid();
	String getDeptname();
}
