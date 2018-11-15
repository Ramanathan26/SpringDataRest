package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	
	private String depthead;
	@Id
	private String deptname;
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
		return "Department [depthead=" + depthead + ", deptname=" + deptname + "]";
	}

}
