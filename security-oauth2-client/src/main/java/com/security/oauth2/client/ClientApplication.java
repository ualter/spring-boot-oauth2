package com.security.oauth2.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@ComponentScan(basePackages= {"com.security.oath2.client"})
public class ClientApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).run(args);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.antMatcher("/**")
				.authorizeRequests()
			.antMatchers("/login**")
				.permitAll().anyRequest()
			.authenticated();
		//@formatter:on
	}

}
