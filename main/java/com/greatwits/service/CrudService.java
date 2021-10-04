package com.greatwits.service;

import java.util.List;

import com.greatwits.Employee;

public interface CrudService {
	public Employee addEmployee(Employee emp);
	public void removeEmployee(int eid);
	public Employee updateEmployee(Employee emp);
	List<Employee> showAllEmployees();
	
}
