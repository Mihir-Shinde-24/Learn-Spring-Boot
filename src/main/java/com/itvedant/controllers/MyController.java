package com.itvedant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/admin")
	public String getAdmin()
	{
		return "This is Admin Page";
	}
	
	@GetMapping("/user")
	public String getLoggedInUser()
	{
		return "This is User Page";
	}
	
	@GetMapping("/home")
	public String getHome()
	{
		return "This is HOMEPAGE for Any User Page";
	}
	
}
