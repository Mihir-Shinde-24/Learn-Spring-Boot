package com.itvedant.services;

import java.util.List;

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
		return repo.findAll();
	}

	@Override
	public List<Employee> addEmployee(Employee newEmp)
	{
		repo.save(newEmp);
		return repo.findAll();
	}

	@Override
	public List<Employee> updateEmployee(Employee newEmp)
	{
		return null;
	}

	@Override
	public List<Employee> deleteEmployee(Employee delEmp)
	{
		return null;
	}

}
