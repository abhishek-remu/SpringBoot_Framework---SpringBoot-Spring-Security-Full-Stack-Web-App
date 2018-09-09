package com.abhishek.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abhishek.app.entities.User;
import com.abhishek.app.services.UserService;

@SpringBootApplication
public class NHSystemApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(NHSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			{
				User newUser= new User("admin@mail.com","Admin","123456");
				userService.createAdmin(newUser);
				
			}
			
	}
}
