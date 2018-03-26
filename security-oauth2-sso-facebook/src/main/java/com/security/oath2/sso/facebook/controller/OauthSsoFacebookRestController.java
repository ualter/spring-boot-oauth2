package com.security.oath2.sso.facebook.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthSsoFacebookRestController {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
