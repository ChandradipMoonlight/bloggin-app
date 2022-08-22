package com.blog.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.enitity.User;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.builder.MessageProperties;
import com.blog.app.dto.UserDTO;
import com.blog.app.dto.UserInputDTO;
import com.blog.app.repositories.UserRepo;
import com.blog.app.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserInputDTO userInputDTO) {
		User save = userRepo.save(modelMapper.map(userInputDTO, User.class));
		return userToDto(save);
	}

	@Override
	public UserDTO updateUser(UserInputDTO userInputDTO, Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

		if (userInputDTO.getUserName() != null) {
			user.setUserName(userInputDTO.getUserName());
		}
		if (userInputDTO.getEmail() != null) {
			user.setEmail(userInputDTO.getEmail());
		}
		if (userInputDTO.getPassword() != null) {
			user.setPassword(userInputDTO.getPassword());
		}
		if (userInputDTO.getAbout() != null) {
			user.setAbout(userInputDTO.getAbout());
		}
		User updatedUser = userRepo.save(user);
		return userToDto(updatedUser);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

		return userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = userRepo.findAll();
		List<UserDTO> userDTOList = userList.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userDTOList;
	}

	@Override
	public String deleteUser(Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
		userRepo.delete(user);
		return MessageProperties.DELETED_USER.getMessage();
	}

	public User dtoToUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
//		User user = new User();
//		user.setUserId(userDTO.getUserId());
//		user.setUserName(userDTO.getUserName());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword(userDTO.getPassword());
//		user.setAbout(userDTO.getAbout());
		return user;
	}

	public UserDTO userToDto(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

}
