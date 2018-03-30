package com.security.oauth2.client;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientApplicationController {
	
	@GetMapping("/userInfo")
	public String userInfo(Model model, Principal principal) {
		model.addAttribute("name", principal.getName());
		return "userInfo";
	}

}
