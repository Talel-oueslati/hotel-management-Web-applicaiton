package com.exemple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByEmail(String email); 
	 }
