package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@CrossOrigin()
@RepositoryRestResource(collectionResourceRel="departments",path="departments",excerptProjection=DeptRecords.class)
public interface DeptRepo extends JpaRepository<Department, Integer>{

	@RestResource(path = "bydeptname", rel = "bydeptname")
    Page<Department> findAllBydeptnameContaining(@Param("deptname") String deptname,Pageable pageable);
	
//	@RestResource(path = "bydeptid", rel = "bydeptid")
//    Page<Department> findAllBydeptidContaining(@Param("deptid") int deptid,Pageable pageable);
	
}
