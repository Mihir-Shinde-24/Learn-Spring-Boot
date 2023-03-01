package com.itvedant.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itvedant.models.Employee;

@Controller
public class MyController {

	List<Employee> allemp = new ArrayList<>();

	@GetMapping({ "/", "/home" })
	public String home(Model model)
	{

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "home.html";
	}
	
	

	@PostMapping("/addemp")
	public String addEmp(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, Model model)
	{
		System.out.println(bindingResult.getFieldErrors());
		
		if (bindingResult.hasErrors())
		{
			model.addAttribute("employee", employee);			
			return "home.html";
		}
		
		allemp.add(employee);
		System.out.println(allemp);

		return "success.html";
	}


	


}
