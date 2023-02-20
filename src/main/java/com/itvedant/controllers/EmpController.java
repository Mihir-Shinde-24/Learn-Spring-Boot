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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 1. Home Page
	@GetMapping({"/","/home","/index"})
	public String index(Model model)
	{
		List<Employee> employees = service.getEmployees();	
		model.addAttribute("employees", employees);
		return "index.html";
	}
	
	// 2. Register Page
	@GetMapping("/register")
	public String register(Model model)
	{
		Employee e = new Employee();			
		model.addAttribute("employee",e);	// adding empty model for two way data binding
		return "register.html";
	}
	
	// 3. Update Page
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable int id)
	{
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update.html";
	}
	/* CRUD Operation Mappings */

	// 1. Add Employee
	@PostMapping("/addemp")
	public String addEmployee( @ModelAttribute("employee") Employee newEmp)
	{
		service.addEmployee(newEmp);	
		return "redirect:/index";
	}

	// 2. Update Employee
	@PutMapping("/updateemp/{id}")
	public String updateEmployee(@ModelAttribute("employee") Employee newEmp)
	{
		 service.updateEmployee(newEmp);
		 return "redirect:/index";
	}

	// 3. Delete Employee
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		service.deleteEmployee(id);
		return "redirect:/index"; 
	}

}
