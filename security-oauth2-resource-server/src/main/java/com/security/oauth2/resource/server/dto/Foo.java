package com.security.oauth2.resource.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foo {
	
	private Long   id;
	private String name;
	private String user;

}
