package com.itvedant.services;

import java.util.List;

import com.itvedant.models.Employee;

public interface Services {

	// 1. Get employees
	public List<Employee> getEmployees();

	// 2. Add employee
	public List<Employee> addEmployee(Employee newEmp);

	// 3. Update Employee
	public List<Employee> updateEmployee(Employee newEmp);

	// 4. Delete Employee
	public List<Employee> deleteEmployee(int id);

	
	
	/* Custom Operations */	
	
	// 1. Find By Id	
	public Employee getEmployeeById(int id);
	
	// 2. Find By firstName
	public List<Employee> getEmployeesByFirstName(String firstName);

	// 3. Find By firstName and email
	public List<Employee> getEmployeesByFirstNameAndEmail(String firstName,String email);
	
}
