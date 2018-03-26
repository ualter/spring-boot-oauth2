package com.security.oath2.sso.facebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OauthSsoFacebookController {
	
	
	@RequestMapping("/unauthenticated")
	public String unauthenticated() {
	  log.debug("/unauthenticated called!");
	  return "redirect:/?error=true";
	}

}
