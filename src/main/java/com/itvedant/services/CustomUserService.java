package com.itvedant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itvedant.models.CustomUser;
import com.itvedant.repositories.CustomUserRepo;

@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	CustomUserRepo repo;

	public String registerUser(CustomUser customUser)
	{
		repo.save(customUser);
		return customUser.getName()+" User Registered Successfully";
	}

	/* Authentications Methods */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return repo.findByName(username);
	}

	
}
