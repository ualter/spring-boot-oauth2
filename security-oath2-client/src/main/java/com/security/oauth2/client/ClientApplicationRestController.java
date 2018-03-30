package com.security.oath2.client;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientApplicationRestController {
	
	@RequestMapping("/user")
	public String home(Principal user) {
		return "Hello " + user.getName();
	}

}
