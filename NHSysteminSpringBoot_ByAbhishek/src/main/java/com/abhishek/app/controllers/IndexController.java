package com.abhishek.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String showIndexPage() {
		return "views/loginForm";
		
	}
	@GetMapping("/login")
	public String showLoginForm() {
		return "views/loginForm";
		
	}

}
