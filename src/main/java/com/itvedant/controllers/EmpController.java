package com.itvedant.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.models.Employee;

@RestController
public class EmpController {

	// Using ArrayList as a Resource instead of DB
	List<Employee> employees = new ArrayList<>();

	public EmpController()
	{
		// Added some sample employees..
		employees.add(new Employee(1, "Mihir", "mihir2403@gmail.com"));
		employees.add(new Employee(2, "Harry", "harry2403@gmail.com"));
	}

	// 1. Get all the employees in Response Body
	@GetMapping("/getemp")
	public List<Employee> getEmployees()
	{
		return this.employees;
	}

	// 2. To Add a new employee
	@PostMapping("/addemp")
	public List<Employee> addEmployee(@RequestBody Employee newEmp)
	{
		employees.add(newEmp);
		return this.employees;
	}

	// 3. To Update details of a particular Employee
	@PutMapping("/updateemp")
	public List<Employee> updateEmployee(@RequestBody Employee newEmp)
	{
		for (int i = 0; i < employees.size(); i++)
		{
			Employee curEmployee = employees.get(i);

			if (curEmployee.equals(newEmp))
			{
				curEmployee.setFirstName(newEmp.getFirstName());
				curEmployee.setEmail(newEmp.getEmail());
			}
		}

		return this.employees;
	}

	// Delete an Employee

	@DeleteMapping("/deleteemp")
	public List<Employee> deleteEmployee(@RequestBody Employee delEmp)
	{
		for (int i = 0; i < employees.size(); i++)
		{
			Employee curEmployee = employees.get(i);
			if (curEmployee.equals(delEmp))
			{
				employees.remove(i);
			}
		}
		return this.employees;
	}

}
