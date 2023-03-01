package com.itvedant.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employee {

	@Min(value = 1)
	private int id;
	
	@NotBlank
	@Size(min = 4, max = 10)
	private String name;
	
	@Email
	private String email;
	
	@Min(value = 500)
	private int salary;
	
	// const
	public Employee(int id, String name, String email, int salary)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public Employee()
	{
		super();	
	}
	
	
	// getter setter
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public int getSalary()
	{
		return salary;
	}
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	@Override
	public String toString()
	{
		return id + ":" + name + ":" + email + ":" + salary;
	}
	
	
	
}
