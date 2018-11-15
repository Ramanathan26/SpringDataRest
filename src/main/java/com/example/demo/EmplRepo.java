package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Employee;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel="employees",path="employees")
public interface EmplRepo extends JpaRepository<Employee, Integer> {

	@RestResource(path = "byName", rel = "byName")
    Page<Employee> findAllByempnameContaining(@Param("name") String empname,Pageable pageable);
	
	@RestResource(path = "byskill", rel = "byskill")
    Page<Employee> findByskillContaining(@Param("skill") String skill,Pageable pageable);
	
	@RestResource(path = "bydept", rel = "bydept")
	Page<Employee> findAllBydeptContaining(@Param("dept") String dept,Pageable pageable);
	
	@RestResource(path = "bydesignation", rel = "bydesignation")
    Page<Employee> findAllBydesignationContaining(@Param("designation") String desigation,Pageable pageable);
	
	@RestResource(path = "bydoj", rel = "bydoj")
    Page<Employee> findAllBydOJ(@Param("doj") Date dOJ,Pageable pageable);
	
	@Transactional
	@RestResource(path = "deletebyName", rel = "deletebyName")
    List<Employee> deleteByempname(@Param("name") String empname);
	
	@Transactional
	@RestResource(path = "deletebyskill", rel = "deletebyskill")
    List<Employee> deleteByskill(@Param("skill") String skill);
	
	@Transactional
	@RestResource(path = "deletebydept", rel = "deletebydept")
    List<Employee> deleteBydept(@Param("dept") String dept);
	
	@Transactional
	@RestResource(path = "deletebydesignation", rel = "deletebydesignation")
    List<Employee> deleteBydesignation(@Param("designation") String designation);
}
