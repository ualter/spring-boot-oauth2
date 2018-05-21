package com.security.oauth2.auth.server.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationServerController {
	
	@RequestMapping("/user/details")
	public Principal user(Principal principal) {
		return principal;
	}

}
