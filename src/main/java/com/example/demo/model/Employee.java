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
	private String dept;
	private String skill;
	
	@Temporal(TemporalType.DATE)
	private Date dOJ;
	private String designation;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
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
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", dept=" + dept + ", skill=" + skill + ", DOJ="
				+ dOJ + ", designation=" + designation + "]";
	}
	
	
}

