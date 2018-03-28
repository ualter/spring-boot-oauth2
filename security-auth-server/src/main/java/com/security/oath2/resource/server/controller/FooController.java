package com.security.oath2.resource.server.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.oath2.resource.server.dto.Foo;

//@Controller
public class FooController {

	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
	@ResponseBody
	public Foo findById(@PathVariable long id) {
		return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
	}
}