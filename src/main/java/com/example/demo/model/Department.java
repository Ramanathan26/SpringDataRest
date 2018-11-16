package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	private int deptid;
	private String depthead;
	private String deptname;
	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDepthead() {
		return depthead;
	}
	public void setDepthead(String depthead) {
		this.depthead = depthead;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", depthead=" + depthead + ", deptname=" + deptname + "]";
	}
	

}
