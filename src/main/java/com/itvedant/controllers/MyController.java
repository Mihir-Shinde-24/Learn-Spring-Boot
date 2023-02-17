package com.itvedant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@CrossOrigin("*") 					// Any Origin can access any Method if we apply annotation on class level
public class MyController {

	@GetMapping("/myapp")
	public String homePage()
	{
		return "home.html";
	}
	
//	@CrossOrigin("*") 						// Any Origin can access
	@CrossOrigin("http://localhost:9090")	// Particular Origin can only Access
	@PostMapping("/accessresource")
	@ResponseBody
	public String accessResource()
	{
		return "Hello Resource!";
	}
	
	
/*
	Further Steps:
	 
	 1. Create Another App 'ConsumerApp' with port 9090 with exact same contents like FirstApp application
	 
	 2. Delete the [POST] '/accessresouce' method of 'ConsumerApp', since we are going to 
	 use this API of 'FirstApp' Application from ConsumerApp application.


	3. If we try to access '/accessresource' api from another origin which is 
	'http://localhost:9090', We will get an Error in browser console..
	
	Error:	Access to fetch at 'http://localhost:8080/accessresource' from 
			origin 'http://localhost:9090' has been blocked by CORS 
			policy: No 'Access-Control-Allow-Origin' header is present on 
			the requested resource. If an opaque response serves your needs, 
			set the request's mode to 'no-cors' to fetch the resource with 
			CORS disabled.
	
	4. So we will add @CrossOrigin("origin") annotation on the '/accessresouce'
	method, so that different origins will be also able to access the api.
*/
}
