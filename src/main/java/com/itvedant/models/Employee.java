package com.itvedant.models;

// POJO CLASS Employee - 
//- Plain Old Java Object
//- It is an ordinary object, which is not bound by any special restriction. 
//- It is not tied to any Java Framework; any Java Program can use it.
public class Employee {

	// fields
	private int id;
	private String firstName;
	private String email;

	// constructor
	public Employee(int id, String firstName, String email)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.email = email;
	}

	// getters & Setters
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Employee newEmp = (Employee) obj;
		
		return this.getId() == newEmp.getId();
	}

}
