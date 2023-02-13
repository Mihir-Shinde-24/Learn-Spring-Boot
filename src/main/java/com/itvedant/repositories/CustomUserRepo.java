package com.itvedant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.itvedant.models.CustomUser;

public interface CustomUserRepo extends JpaRepository<CustomUser, Integer>{

	UserDetails findByName(String username);

}
