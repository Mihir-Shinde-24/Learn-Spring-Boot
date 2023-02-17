package com.itvedant.controllers;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itvedant.models.Student;

@Controller // When dealing with frontend, we use @Controller instead of @RestController
public class MyController {

	@GetMapping({ "/", "/home" })
	public String home(Model model)
	{
		Student s = new Student(1, "Ram", 45, "ram@gmail.com");

		model.addAttribute("student", s);

		return "home.html";
	}

}
