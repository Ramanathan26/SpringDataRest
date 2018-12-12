package com.ntt.employee;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ntt.department.DeptRecords;
import com.ntt.model.Department;
import com.ntt.model.Employee;

@Projection(name="emprecords",types={Employee.class})
public interface EmpRecords {
	
int getEmpid();
String getEmpname();
String getSkill();
String getDesignation();
DeptRecords getDeptid();
Date getDoj();
int getGrade();
float getSalary();
String getCity();
String getCountry();

}
