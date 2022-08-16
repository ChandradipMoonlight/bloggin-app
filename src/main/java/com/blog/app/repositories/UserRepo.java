package com.blog.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.enitity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
}
