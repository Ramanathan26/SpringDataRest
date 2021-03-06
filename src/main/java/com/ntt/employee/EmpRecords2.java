package com.ntt.employee;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.ntt.model.Employee;

@Projection(name="emprecords2",types={Employee.class})
public interface EmpRecords2 {
	
	int getEmpid();
	String getEmpname();
	String getSkill();
	String getDesignation();
	Date getDoj();
	int getGrade();
	float getSalary();
	String getCity();
	String getCountry();
}
