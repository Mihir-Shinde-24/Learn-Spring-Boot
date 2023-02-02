package com.itvedant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

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
	
	
	
	/* Life Cycle Annotations */	
	
	@PrePersist
	public void beforeSave()
	{
		System.out.println("Before Saving...");
	}
	
	@PostPersist
	public void afterSave()
	{
		System.out.println("After Saving...");
	}
	
	@PreUpdate
	public void beforeUpdate()
	{
		System.out.println("Before Updating...");
	}
	
	@PostUpdate
	public void afterUpdate()
	{
		System.out.println("After Updating...");
	}
	
	@PreRemove
	public void beforeDelete()
	{
		System.out.println("Before Deleting...");
	}
	
	@PostRemove
	public void afterDelete()
	{
		System.out.println("After Deleting...");
	}

/*
	@PostLoad
	public void afterFetch()
	{
		System.out.println("After Fetching...");
	}
	
*/
	

}
