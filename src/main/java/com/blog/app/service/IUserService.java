package com.blog.app.service;

import java.util.List;

import com.blog.app.dto.UserDTO;
import com.blog.app.dto.UserInputDTO;

public interface IUserService {
	
	UserDTO createUser(UserInputDTO userInputDTO);
	
	UserDTO updateUser(UserInputDTO userInputDTO, Integer userId);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUsers();
	
	String deleteUser(Integer userId);
}
