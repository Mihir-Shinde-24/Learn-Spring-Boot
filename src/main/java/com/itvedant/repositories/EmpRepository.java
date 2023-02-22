package com.itvedant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> findAllByFirstName(String firstName);
}
