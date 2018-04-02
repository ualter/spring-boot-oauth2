package com.security.oauth2.client.password.granttype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClientApp {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApp.class)
						.properties("spring.config.name:client-password-grant-type")
						.build()
						.run(args);
	}

}
