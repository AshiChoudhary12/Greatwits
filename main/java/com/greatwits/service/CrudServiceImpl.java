package com.greatwits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatwits.Employee;
import com.greatwits.EmployeeRepository; 

@Service
public class CrudServiceImpl implements CrudService {
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> showAllEmployees() {
		return (List<Employee>) employeeRepo.findAll();
		
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	@Override
	public void removeEmployee(int eid) {
		 employeeRepo.deleteById(eid);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}


}
