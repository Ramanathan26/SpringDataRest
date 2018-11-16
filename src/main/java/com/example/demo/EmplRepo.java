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

@CrossOrigin()
@RepositoryRestResource(collectionResourceRel="employees",path="employees")
public interface EmplRepo extends JpaRepository<Employee, Integer> {

	@RestResource(path = "byname", rel = "byname")
    Page<Employee> findAllByempnameContaining(@Param("name") String empname,Pageable pageable);
	
	@RestResource(path = "byskill", rel = "byskill")
    Page<Employee> findByskillContaining(@Param("skill") String skill,Pageable pageable);
	
	@RestResource(path = "bydesignation", rel = "bydesignation")
    Page<Employee> findAllBydesignationContaining(@Param("designation") String designation,Pageable pageable);
	
	@RestResource(path = "bydoj", rel = "bydoj")
    Page<Employee> findAllBydoj(@Param("doj") Date doj,Pageable pageable);
	
	@RestResource(path = "bygrade", rel = "bygrade")
    Page<Employee> findAllBygrade(@Param("grade") int grade,Pageable pageable);
	
	@RestResource(path = "bysalary", rel = "bysalary")
    Page<Employee> findAllBysalary(@Param("salary") float salary,Pageable pageable);
	
	@RestResource(path = "bycity", rel = "bycity")
    Page<Employee> findAllBycity(@Param("city") String city,Pageable pageable);
	
	@RestResource(path = "bycountry", rel = "bycountry")
    Page<Employee> findAllBycountry(@Param("country") String country,Pageable pageable);
	
//	@Transactional
//	@RestResource(path = "deletebyname", rel = "deletebyname")
//    List<Employee> deleteByempname(@Param("name") String empname);
//	
//	@Transactional
//	@RestResource(path = "deletebyskill", rel = "deletebyskill")
//    List<Employee> deleteByskill(@Param("skill") String skill);
//	
//	@Transactional
//	@RestResource(path = "deletebydesignation", rel = "deletebydesignation")
//    List<Employee> deleteBydesignation(@Param("designation") String designation);
//	
//	@Transactional
//	@RestResource(path = "deletebydoj", rel = "deletebydoj")
//    List<Employee> deleteBydoj(@Param("doj") String doj);
//	
//	@Transactional
//	@RestResource(path = "deletebygrade", rel = "deletebygrade")
//    List<Employee> deleteBygrade(@Param("grade") String grade);
//	
//	@Transactional
//	@RestResource(path = "deletebysalary", rel = "deletebysalary")
//    List<Employee> deleteBysalary(@Param("salary") String salary);
//	
//	@Transactional
//	@RestResource(path = "deletebycity", rel = "deletebycity")
//    List<Employee> deleteBycity(@Param("city") String city);
//	
//	@Transactional
//	@RestResource(path = "deletebycountry", rel = "deletebycountry")
//    List<Employee> deleteBycountry(@Param("country") String country);
}
