package com.security.oath2.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.security.oath2"})
public class Oath2AuthorizationServerApp extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Oath2AuthorizationServerApp.class, args);
	}
	

}
