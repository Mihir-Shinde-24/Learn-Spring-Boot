package com.itvedant.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.custom_exceptions.EmployeeNotFoundException;
import com.itvedant.models.Employee;
import com.itvedant.services.Services;

import jakarta.validation.Valid;

@RestController
public class EmpController {

	@Autowired
	Services service;

	// 1. Fetch Employees
	@GetMapping("/getemp")
	public ResponseEntity<List<Employee>> getEmployees()
	{
		List<Employee> employees = service.getEmployees();
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(employees);
	}

	// 2. Add Employee
	@PostMapping("/addemp")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody @Valid Employee newEmp)
	{
		List<Employee> employees = service.addEmployee(newEmp);
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}

	// 3. Update Employee
	@PutMapping("/updateemp")
	public ResponseEntity<List<Employee>> updateEmployee(@RequestBody @Valid Employee newEmp)
	{
		List<Employee> employees = service.updateEmployee(newEmp);
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}

	// 4. Delete Employee
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("id") int id)
	{
		List<Employee> employees = service.deleteEmployee(id);
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}

	/* Custom Operations */

	// 1. Find Employee by id
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		Employee employee = service.getEmployeeById(id);
		return ResponseEntity.status(employee != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employee);
	}

	// 2. Find Employee by firstName
	@GetMapping("/findbyfirstname/{firstname}")
	public ResponseEntity<List<Employee>> getEmployeesByFirstName(@PathVariable("firstname") String firstName)
	{
		List<Employee> employees = service.getEmployeesByFirstName(firstName);
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}

	// 3. Find Employee by firstName & email using Query Parameter
	@GetMapping("/findbyfnameandemail")
	public ResponseEntity<List<Employee>> getEmployeesByFirstNameAndEmail(@RequestParam("firstName") String firstName,
			@RequestParam("email") String email)
	{
		List<Employee> employees = service.getEmployeesByFirstNameAndEmail(firstName, email);
		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
	}
	
	
	
	/* Custom Exception Handling related to Employees Only */
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> employeeNotFoundException(EmployeeNotFoundException e)
	{
		return new HashMap<>(Map.of("Error",e.getMessage()));
	}

	
}
