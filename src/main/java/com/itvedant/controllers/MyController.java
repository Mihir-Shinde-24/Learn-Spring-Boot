package com.itvedant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@GetMapping({"/","/home"})
	public String homePage()
	{
		return "home.html";
	}
	
	@PostMapping("/savedata")
	public String saveData(String userName)
	{
		System.out.println(userName);
		return "home.html";
	}
}
