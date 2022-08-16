package com.blog.app.service;

import java.util.List;

import com.blog.app.dto.UserDTO;

public interface IUserService {
	
	UserDTO createUser(UserDTO userDTO);
	
	UserDTO updateUser(UserDTO userDTO, Integer userId);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUsers();
	
	String deleteUser(Integer userId);
}
