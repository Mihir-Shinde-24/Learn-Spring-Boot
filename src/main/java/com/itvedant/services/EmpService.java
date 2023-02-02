package com.itvedant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.models.Employee;
import com.itvedant.repositories.EmpRepository;

//Service: In service class, we will apply the actual business logic
@Service
public class EmpService implements Services {

	@Autowired
	EmpRepository repo;

	@Override
	public List<Employee> getEmployees()
	{
		List<Employee> employees = repo.findAll();

		if (!employees.isEmpty())
		{
			return employees;
		}
		return null;
	}

	@Override
	public List<Employee> addEmployee(Employee newEmp)
	{
		if (newEmp.getFirstName() != null || newEmp.getEmail() != null)
		{
			repo.save(newEmp);
			return repo.findAll();
		}

		return null;
	}

	@Override
	public List<Employee> updateEmployee(Employee newEmp)
	{
		Optional<Employee> employee = repo.findById(newEmp.getId());

		if (employee.isPresent())
		{
			newEmp.setCreationDate(employee.get().getCreationDate());
			repo.save(newEmp);
			return repo.findAll();
		}

		return null;
	}

	@Override
	public List<Employee> deleteEmployee(Employee delEmp)
	{
		Optional<Employee> employee = repo.findById(delEmp.getId());

		if (employee.isPresent())
		{
			repo.delete(delEmp);
			return repo.findAll();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id)
	{
		Optional<Employee> employee = repo.findById(id);

		if (employee.isPresent())
		{
			return employee.get();
		}

		return null;
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName)
	{
		List<Employee> employees = repo.findByFirstName(firstName);

		if (!employees.isEmpty())
		{
			return employees;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeesByFirstNameAndEmail(String firstName, String email)
	{
		List<Employee> employees = repo.findByFirstNameAndEmail(firstName, email);

		if (!employees.isEmpty())
		{
			return employees;
		}
		return null;
	}

}
