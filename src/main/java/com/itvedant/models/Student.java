package com.itvedant.models;

public class Student {

	/* Fields */
	private int id;
	private String name;
	private int marks;
	private String email;
	
	
	/* Constructor */
	public Student(int id, String name, int marks, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.email = email;
	}
	
	public Student(){}

	
	/* Getters & Setters */
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

	public int getMarks()
	{
		return marks;
	}

	public void setMarks(int marks)
	{
		this.marks = marks;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	
	
}
