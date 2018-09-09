package com.abhishek.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.app.entities.Task;
import com.abhishek.app.entities.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
