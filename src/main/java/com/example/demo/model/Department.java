package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	private int deptid;
	@OneToOne
	@JoinColumn(name="deptheadid",nullable=true)
	private Employee deptheadid;
	private String deptname;
	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public Employee getDeptheadid() {
		return deptheadid;
	}
	public void setDeptheadid(Employee deptheadid) {
		this.deptheadid = deptheadid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptheadid=" + deptheadid + ", deptname=" + deptname + "]";
	}
}
