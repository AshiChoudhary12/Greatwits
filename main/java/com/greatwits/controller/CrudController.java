package com.greatwits.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatwits.Employee;
import com.greatwits.service.CrudServiceImpl;


@RestController
@RequestMapping("/emp")
public class CrudController {
	@Autowired
	private CrudServiceImpl cService;
	
	@GetMapping("/all")
	public List<Employee> showAll(){
		 return cService.showAllEmployees();
	}
	
	
	
	@PostMapping("/post")
	public Employee saveEmployee(@RequestBody Employee emp) {
		System.out.println("employee save work");
		cService.addEmployee(emp);
		return emp;
	}
	
	@PutMapping("/put")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return cService.updateEmployee(emp);
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam int eid) {
		 cService.removeEmployee(eid);
		 return "Student Deleted!";
	}
}
