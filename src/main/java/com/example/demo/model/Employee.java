package com.example.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="seq_gen")
	@SequenceGenerator(name="seq_gen",sequenceName="id_seq",allocationSize=1)
	private int empid;
	private String empname;
	private String skill;
	@Temporal(TemporalType.DATE)
	private Date dOJ;
	private String designation;
	private int grade;
	private String city;
	private String country;
	private Department dept;
	
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
	public Date getDOJ() {
		return dOJ;
	}
	public void setDOJ(Date dOJ) {
		this.dOJ = dOJ;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", skill=" + skill + ", dOJ=" + dOJ
				+ ", designation=" + designation + ", grade=" + grade + ", city=" + city + ", country=" + country
				+ ", dept=" + dept + "]";
	}
	
}

