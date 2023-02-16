package com.itvedant.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	

	/* We can disable csrf like this */
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception
//	{
//		http.csrf().disable();
//	}
	 
	/* But If we disable csrf , the user as well as attacker both will be able to send request*/
	/* Thus, our requests should always have csrf protection. So we will not disable it */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();
	}
	
	/*Either we can use above implementation or don't override the method */
	
	
}
