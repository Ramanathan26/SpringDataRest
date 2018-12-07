package com.example.demo;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
