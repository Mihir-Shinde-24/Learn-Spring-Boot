package com.itvedant.controllers;

import javax.annotation.PostConstruct;
import javax.persistence.PrePersist;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.models.CustomUser;
import com.itvedant.services.CustomUserService;

@RestController
public class CustomUserController {

	/* Dependecies */

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	CustomUserService service;

	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody @Valid CustomUser customUser)
	{
		String encodedPW = encoder.encode(customUser.getPasscode());
		customUser.setPasscode(encodedPW);
		
		String msg = service.registerUser(customUser);
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

}
