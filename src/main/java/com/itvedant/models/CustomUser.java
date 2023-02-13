package com.itvedant.models;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "CUSTOM_USER")
public class CustomUser implements UserDetails{
		
	/* Fields */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@NotBlank(message = "Invalid Name")
	private String name;
	
	@Column
	@Email(message = "Invalid Email")
	private String email;
	
	@Column
	@NotBlank(message = "Invalid Password")
	private String passcode;
	
	@Column
	@Pattern(regexp = "ROLE\\_(ADMIN|USER)" ,message = "ROLE should ROLE_ADMIN or ROLE_USER")
	private String role;
	

	/* Constructors */

	public CustomUser()
	{
		super();
	}

	/* Getter Setter */
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPasscode()
	{
		return passcode;
	}

	public void setPasscode(String passcode)
	{
		this.passcode = passcode;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
	
	/* Authentication Methods */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		HashSet<SimpleGrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(this.role));
		
		return roles;
		
	}

	@Override
	public String getPassword()
	{
		return this.passcode;
	}

	@Override
	public String getUsername()
	{
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}
	
	
	
	
	
	
	
	
}
