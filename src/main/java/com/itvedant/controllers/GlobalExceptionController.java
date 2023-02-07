package com.itvedant.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
   Exception Handling 
   -------------------
   
  	1] getBindingResult() : BindingResult holds the result of a validation and binding and contains
	  errors that may have occurred.
	2] getFieldErrors() : Returns a List of all Field errors
	
*/

@RestControllerAdvice
public class GlobalExceptionController {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> methodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		Map<String,String> errMap = new HashMap<>();
		
		exception
			.getBindingResult()
				.getFieldErrors()
					.forEach(err -> errMap.put( err.getField() , err.getDefaultMessage() ));
		
		return errMap;
	}
}
