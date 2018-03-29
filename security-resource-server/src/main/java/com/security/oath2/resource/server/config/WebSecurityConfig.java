package com.security.oath2.resource.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;

import com.security.oath2.resource.server.services.DatabaseUserDetailsService;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private DatabaseUserDetailsService userDetailsService;
//	 
//	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
		
		// In case the users were in a Database (see DatabaseUserDetailsService)
		// auth.authenticationProvider(authenticationProvider());  
		
		auth
			.inMemoryAuthentication()
				.withUser("john").password("123").roles("USER");
		
		//@formatter:on
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		
		http
			.antMatcher("/**")
				.authorizeRequests()
			.antMatchers("/login")
				.permitAll()
 			.anyRequest()
 				.authenticated()
			.and()
				.formLogin().permitAll()
			.and()
				.httpBasic()
			.and()
				.csrf().disable();
			;
			
		//@formatter:on
	}
	
	
//	public void s() {
//		OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(""); 
//	}
	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	    authProvider.setUserDetailsService(userDetailsService);
//	    authProvider.setPasswordEncoder(encoder());
//	    return authProvider;
//	}
//	
//	@Bean
//	public PasswordEncoder encoder() {
//	    return new BCryptPasswordEncoder(11);
//	}
	
	
	
}