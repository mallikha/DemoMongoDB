package com.mongodb.demoMongoDb.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@RequestMapping("/")
	public List<Employee> findAll(){
		List<Employee> employees = new ArrayList<Employee>();
		employees =service.findAll();
		return employees;
	}
	@PostMapping("/add")
	public String add(@RequestBody Employee emp) {
		return service.add(emp);
			
	}
	@PutMapping("/update")
	public String update(@RequestBody Employee emp) {
		return service.update(emp);
			
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		return service.delete(id);
	}
}
