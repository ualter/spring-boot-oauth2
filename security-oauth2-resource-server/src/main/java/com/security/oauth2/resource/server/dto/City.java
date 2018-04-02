package com.security.oauth2.resource.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
	
	private Integer id;
	private String  name;
	private boolean capital;
	private String country;

}
