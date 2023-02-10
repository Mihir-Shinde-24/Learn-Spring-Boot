package com.itvedant.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	// In Memory Authentication (Hard Coded Username and Password)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("mihir")
									 .password(encoder().encode("mihir123"))
									 .roles("ADMIN","USER")
									 .and()
									 .withUser("rahul")
									 .password(encoder().encode("rahul123"))
									 .roles("USER");
	
	}
	
	// For Role Based Access to Pages
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET , "/home").permitAll()
			.antMatchers("/user").hasAnyRole("ADMIN","USER")
			.antMatchers("/admin").hasRole("ADMIN")
			.and()
			.formLogin();
	}
}
