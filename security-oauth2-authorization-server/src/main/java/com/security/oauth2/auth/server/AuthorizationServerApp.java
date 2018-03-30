package com.security.oauth2.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.security.oauth2"})
public class AuthorizationServerApp extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApp.class, args);
	}
	


	// BUG!!?
	/*@Autowired
	private ResourceServerProperties sso;
	
	@Bean
	@Primary
	public ResourceServerTokenServices remoteTokenServices() {
		return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
	}*/
	
}
