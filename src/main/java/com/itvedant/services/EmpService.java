package com.itvedant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itvedant.models.Employee;
//Service: In service class, we will apply the actual business logic

@Service  
public class EmpService implements Services {

	// Using ArrayList as a Resource instead of DB
	List<Employee> employees = new ArrayList<>();

	public EmpService()
	{
		// Added some sample employees..
		employees.add(new Employee(1, "Mihir", "mihir2403@gmail.com"));
		employees.add(new Employee(2, "Harry", "harry2403@gmail.com"));
	}

	@Override
	public List<Employee> getEmployees()
	{
		return this.employees;
	}

	@Override
	public List<Employee> addEmployee(Employee newEmp)
	{
		employees.add(newEmp);
		return this.employees;
	}

	@Override
	public List<Employee> updateEmployee(Employee newEmp)
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

	@Override
	public List<Employee> deleteEmployee(Employee delEmp)
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
