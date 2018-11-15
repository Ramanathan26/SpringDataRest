package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@CrossOrigin()
@RepositoryRestResource(collectionResourceRel="departments",path="departments")
public interface DeptRepo extends JpaRepository<Department, Integer>{

}
