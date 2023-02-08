package com.itvedant.custom_exceptions;

public class EmployeeNotFoundException extends RuntimeException{

	String msg;

	public EmployeeNotFoundException(String msg)
	{
		super(msg);
	}
	
}
