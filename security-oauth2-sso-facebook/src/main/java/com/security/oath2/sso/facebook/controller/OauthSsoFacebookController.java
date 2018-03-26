package com.security.oath2.sso.facebook.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OauthSsoFacebookController {

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@RequestMapping({ "/user" })
	public Principal user(Principal principal) {
		String msg = String.format("User:%s, Access_Token:%s", principal.getName(),oauth2ClientContext.getAccessToken());
		log.info(msg);
		return principal;
	}
	
	@RequestMapping({ "/userInfo" })
	public Principal userInfo(Principal principal) {
		String msg = String.format("UserInfo:%s, Access_Token:%s", principal.getName(),oauth2ClientContext.getAccessToken());
		log.info(msg);
		return principal;
	}

}
