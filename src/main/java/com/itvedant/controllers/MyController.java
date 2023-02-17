package com.itvedant.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itvedant.models.Student;

@Controller // When dealing with frontend, we use @Controller instead of @RestController
public class MyController {

	@GetMapping({ "/", "/home" })
	public String home(Model model)
	{
		List<Student> students = new ArrayList<>();		
		students.add(new Student(1, "Ram", 90, "ram@gmail.com"));
		students.add(new Student(2, "Sam", 75, "sam@gmail.com"));
		students.add(new Student(3, "Tom", 80, "tom@gmail.com"));

		model.addAttribute("students", students);
		return "home.html";
	}

}
