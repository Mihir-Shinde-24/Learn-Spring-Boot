package com.itvedant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // When dealing with frontend, we use @Controller instead of @RestController
public class MyController {

	@GetMapping("/home/{name}")
	public String home(Model model, @PathVariable("name") String name)
	{
		model.addAttribute("name",name);
		return "home.html";
	}
	
	@GetMapping("/about")
	public String about()
	{
		return "about.html";
	}

}
