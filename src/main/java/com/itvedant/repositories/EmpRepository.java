package com.itvedant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	/* JPA Queries */
	
	// 1. Find By firstName
	public List<Employee> findByFirstName(String firstName);
	
	// 2. Find By firstName and email
	public List<Employee> findByFirstNameAndEmail(String firstName, String email);
}
