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
		}

		return null;
	}

	@Override
	public List<Employee> updateEmployee(Employee newEmp)
	{
		Optional<Employee> employee = repo.findById(newEmp.getId());

		if (employee.isPresent())
		{
			repo.save(newEmp);
			return repo.findAll();
		}

		return null;
	}

	@Override
	public void deleteEmployee(int id)
	{
		Optional<Employee> employee = repo.findById(id);

		repo.delete(employee.get());

	}

	@Override
	public Employee getEmployeeById(int id)
	{
		return repo.findById(id).get();
	}

}
