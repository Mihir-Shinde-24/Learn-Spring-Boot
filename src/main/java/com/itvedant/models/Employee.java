package com.itvedant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// POJO CLASS Employee - 
//- Plain Old Java Object
//- It is an ordinary object, which is not bound by any special restriction. 
//- It is not tied to any Java Framework; any Java Program can use it.

@Entity
public class Employee {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String firstName;

	@Column
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

	public Employee()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj)
	{
		Employee newEmp = (Employee) obj;

		return this.getId() == newEmp.getId();
	}

}
