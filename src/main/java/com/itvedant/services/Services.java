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
	public void deleteEmployee(int id);
	
	
	/* Custom Methods */
	// 1. Find By Id
	public Employee getEmployeeById(int id);
	
	// 2. Find All By Namme	
	public List<Employee> getEmployeesByFirstName(String firstName);


	
}
