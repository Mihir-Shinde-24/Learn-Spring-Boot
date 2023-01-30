package com.itvedant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.models.Employee;
import com.itvedant.services.Services;

@RestController
public class EmpController {

	@Autowired
	Services service;

	// 1. Get all the employees in Response Body
	@GetMapping("/getemp")
	public List<Employee> getEmployees()
	{
		return this.service.getEmployees();
	}

	// 2. To Add a new employee
	@PostMapping("/addemp")
	public List<Employee> addEmployee(@RequestBody Employee newEmp)
	{
		return this.service.addEmployee(newEmp);
	}

	// 3. To Update details of a particular Employee
	@PutMapping("/updateemp")
	public List<Employee> updateEmployee(@RequestBody Employee newEmp)
	{
		return this.service.updateEmployee(newEmp);
	}

	// Delete an Employee

	@DeleteMapping("/deleteemp")
	public List<Employee> deleteEmployee(@RequestBody Employee delEmp)
	{
		return this.service.deleteEmployee(delEmp);
	}

}
