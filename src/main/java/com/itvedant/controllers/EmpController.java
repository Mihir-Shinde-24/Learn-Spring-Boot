package com.itvedant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	// 1. Fetch Employees
	@GetMapping("/getemp")
	public ResponseEntity<List<Employee>> getEmployees()
	{
		List<Employee> employees = service.getEmployees();			
		return ResponseEntity.status(employees != null? HttpStatus.OK : HttpStatus.NOT_FOUND).body(employees);
	}

	// 2. Add Employee
	@PostMapping("/addemp")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee newEmp)
	{
		List<Employee> employees = service.addEmployee(newEmp);			
		return ResponseEntity.status(employees != null? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}

	// 3. Update Employee
	@PutMapping("/updateemp")
	public ResponseEntity<List<Employee>> updateEmployee(@RequestBody Employee newEmp)
	{
		 List<Employee> employees = service.updateEmployee(newEmp);
		 return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}

	// 4. Delete Employee
	@DeleteMapping("/deleteemp")
	public ResponseEntity<List<Employee>> deleteEmployee(@RequestBody Employee delEmp)
	{
		List<Employee> employees = service.deleteEmployee(delEmp);
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}
	

}
