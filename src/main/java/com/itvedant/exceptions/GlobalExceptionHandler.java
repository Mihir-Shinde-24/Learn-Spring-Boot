package com.itvedant.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errorsMap = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors()
							 .forEach(e -> errorsMap.put(e.getField(), e.getDefaultMessage() ));
		return errorsMap;
	}
}
