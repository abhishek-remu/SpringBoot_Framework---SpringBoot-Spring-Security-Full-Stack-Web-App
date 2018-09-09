package com.abhishek.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhishek.app.services.UserService;


import com.abhishek.app.entities.Task;
import com.abhishek.app.entities.User;
import com.abhishek.app.services.TaskService;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NHSystemApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initDb() {
		{
			User newUser= new User("user@gmail", "User", "123456");
			userService.createUser(newUser);			
		}
		
		{
			User newUser= new User("admin@gmail", "Admin", "123456");
			userService.createUser(newUser);			
		}
		
		Task userTask= new Task("22/7/2018", "11:00 am", "6:00 pm", "You need to work today");
		User user=userService.findOne("user@gmail");
		taskService.addTask(userTask, user);
		
		
	}
	
	@Test
	public void testUser() {
		User user=userService.findOne("user@gmail");
		assertNotNull(user);
		User admin=userService.findOne("admin@gmail");
		assertEquals(admin.getEmail(),"admin@gmail");
		
	}
	@Test
	public void testTask() {
		User user=userService.findOne("user@gmail");
		List<Task> task=taskService.findUserTask(user);
		assertNotNull(task);
		
		
	}
}
