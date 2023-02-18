package com.itvedant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itvedant.models.Employee;
import com.itvedant.services.Services;

@Controller
public class EmpController {

	@Autowired
	Services service;
	
	/* Webpage Mappings */	
	
	@GetMapping({"/","/home","/index"})
	public String index(Model model)
	{
		List<Employee> employees = service.getEmployees();	
		model.addAttribute("employees", employees);
		return "index.html";
	}
	
	@GetMapping("/register")
	public String register(Model model)
	{
		Employee e = new Employee();			
		model.addAttribute("employee",e);	// adding empty model for two way data binding
		return "register.html";
	}

	/* CRUD Operation Mappings */

	// 1. Add Employee
	@PostMapping("/addemp")
	public String addEmployee( @ModelAttribute("employee") Employee newEmp)
	{
		service.addEmployee(newEmp);	
		return "redirect:/index";
	}

//	// 3. Update Employee
//	@PutMapping("/updateemp")
//	public ResponseEntity<List<Employee>> updateEmployee(@RequestBody Employee newEmp)
//	{
//		 List<Employee> employees = service.updateEmployee(newEmp);
//		 return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
//	}
//
//	// 4. Delete Employee
//	@DeleteMapping("/deleteemp")
//	public ResponseEntity<List<Employee>> deleteEmployee(@RequestBody Employee delEmp)
//	{
//		List<Employee> employees = service.deleteEmployee(delEmp);
//		return ResponseEntity.status(employees != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(employees);
//	}

}
