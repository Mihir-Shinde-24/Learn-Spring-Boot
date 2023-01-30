package com.itvedant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	//http://localhost:8080/sum/5/4 
	@GetMapping("/sum/{n1}/{n2}")
	public String sum(@PathVariable("n1") int num1, @PathVariable("n2") int num2)
	{
		return "Sum is: "+(num1+num2);
	}
	
	
	//http://localhost:8080/multiply?n1=4&n2=6
	@GetMapping("/multiply")
	public String multiply(@RequestParam("n1") int num1, @RequestParam("n2") int num2)
	{
		return "Multiplication is: "+(num1*num2);
	}
	
}
