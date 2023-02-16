package com.itvedant.services;

import java.util.Optional;

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
		Optional<CustomUser> prevCU = repo.findByEmail(customUser.getEmail());
		if(prevCU.isEmpty())
		{
			repo.save(customUser);
			return customUser.getName()+" User Registered Successfully";
		}
		return "Email already in use. Try Another";
		
	}

	/* Authentications Methods */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return repo.findByName(username);
	}

	
}
