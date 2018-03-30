package com.security.oauth2.resource.server.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.oauth2.resource.server.dto.Foo;

@Controller
public class FooController {

	//@PreAuthorize("#oauth2.hasScope('read')")
	//@PreAuthorize("#oauth2.isClient()")
	//@PreAuthorize("#oauth2.isUser()")
	@RequestMapping(method = RequestMethod.POST, value = "/foos")
	@ResponseBody
	public Foo findById(@RequestParam long id, Principal user) {
		String userNamePrincipal = user != null ? user.getName() : "NOT AUTHENTICATED!";
		return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4), userNamePrincipal);
	}
}