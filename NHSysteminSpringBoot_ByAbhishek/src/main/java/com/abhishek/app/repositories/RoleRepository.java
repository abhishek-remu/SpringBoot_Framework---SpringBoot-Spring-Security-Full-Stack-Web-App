package com.abhishek.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
