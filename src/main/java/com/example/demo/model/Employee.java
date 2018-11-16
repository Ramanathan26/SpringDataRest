package com.example.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	//@SequenceGenerator(name="seq_gen",sequenceName="id_seq",allocationSize=1)
	private int empid;
	private String empname;
	private String skill;
	private String designation;
	@ManyToOne
	@JoinColumn(name="deptid")
	private Department deptid;
	@Temporal(TemporalType.DATE)
	private Date doj;
	private int grade;
	private float salary;
	private String city;
	private String country;
	
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Department getDeptid() {
		return deptid;
	}
	public void setDeptid(Department deptid) {
		this.deptid = deptid;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", skill=" + skill + ", designation=" + designation
				+ ", deptid=" + deptid + ", doj=" + doj + ", grade=" + grade + ", salary=" + salary + ", city=" + city
				+ ", country=" + country + "]";
	}
	
	}
	

