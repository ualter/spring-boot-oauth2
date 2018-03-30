package com.security.oauth2.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
		auth
			.inMemoryAuthentication()
				.withUser("john").password("123").roles("USER");
		//@formatter:on
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.antMatcher("/**")
				.authorizeRequests()
			.antMatchers("/login","/webjars/**")
				.permitAll()
 			.anyRequest()
 				.authenticated()
			.and()
				.formLogin().permitAll()
			//.and()
			//	.httpBasic()
			;
		//@formatter:on
	}
}
