package com.itvedant.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// POJO CLASS Employee - 
//- Plain Old Java Object
//- It is an ordinary object, which is not bound by any special restriction. 
//- It is not tied to any Java Framework; any Java Program can use it.

@Entity
public class Employee {

	// fields
	
	/* Using SB Validations Annotations */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	@NotBlank(message = "Invalid Name")
	private String firstName;

	@Column
	@Email(message = "Please Enter a Valid Email")
	private String email;
	
	@Column
	@Min(value = 5000 , message = "Salary should be greater than or equal to 5000")
	private int salary;
	
	
	/* Using RegEx for Validation */
	@Column
	@Pattern(regexp = "\\+91[6-9][0-9]{9}|0[6-9][0-9]{9}",message = "Invalid Mobile Number")
	private String mobile;	
	
	
	/* Hibernate Auditing Annotations */
	
	@Column
	@CreationTimestamp
	private Date creationDate;
	
	@Column
	@UpdateTimestamp
	private Date updationDate;
	
	
	
	
	// No-Arg Constructor
	public Employee(){	}
	

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
	
	public Date getCreationDate()
	{
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate)
	{
		this.creationDate = creationDate;
	}
	
	public Date getUpdationDate()
	{
		return updationDate;
	}
	
	public void setUpdationDate(Date updationDate)
	{
		this.updationDate = updationDate;
	}
	
	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}


	public String getMobile()
	{
		return mobile;
	}


	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
	

}
