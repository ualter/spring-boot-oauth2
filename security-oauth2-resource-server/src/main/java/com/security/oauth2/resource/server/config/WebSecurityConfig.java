package com.security.oauth2.resource.server.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private DatabaseUserDetailsService userDetailsService;
//	 
//	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
		/* Not necessary, we are using Oauth2 Tokens given by the Authorization Server
		 auth
			.inMemoryAuthentication()
				.withUser("john").password("123").roles("USER");*/
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