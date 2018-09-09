package com.abhishek.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhishek.app.entities.User;
import com.abhishek.app.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "views/registerForm";
		
	}
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult bindingResult ,Model model) {
		System.out.println(" "+user.getEmail()+" "+user.getName()+" "+user.getPassword());
		
		if(bindingResult.hasErrors()) {
			System.out.println("bindingResult");
			return "views/registerForm";
			
		}
		
		if(userService.isUserPresent(user.getEmail())) {
			System.out.println("Exist");
			model.addAttribute("exist",true);
			return "views/registerForm";
		}
		userService.createUser(user);
		return "views/success";
	}

}
