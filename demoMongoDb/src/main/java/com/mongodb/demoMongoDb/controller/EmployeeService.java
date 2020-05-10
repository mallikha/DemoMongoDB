package com.mongodb.demoMongoDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	public List<Employee> findAll() {
		return repo.findAll();
	}
	public String add(Employee emp) {
		return repo.save(emp);
	}
	public String update(Employee emp) {
		return repo.update(emp);
	}
	public String delete(String id) {
		return repo.delete(id);
		
	}

}
