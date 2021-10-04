package com.greatwits.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee-table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private String edept;
	
	
	public Employee() {
		
	}
	
	public Employee(int eid, String ename, String edept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.edept = edept;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEdept() {
		return edept;
	}
	public void setEdept(String edept) {
		this.edept = edept;
	}

}
