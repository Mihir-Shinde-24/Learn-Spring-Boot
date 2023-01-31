package com.itvedant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
