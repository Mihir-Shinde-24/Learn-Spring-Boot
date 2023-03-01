package com.itvedant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.models.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
