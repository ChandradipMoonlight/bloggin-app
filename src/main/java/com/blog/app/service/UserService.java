package com.blog.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.enitity.User;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.builder.MessageProperties;
import com.blog.app.dto.UserDTO;
import com.blog.app.repositories.UserRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User save = userRepo.save(dtoToUser(userDTO));
		return userToDto(save);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

		if (userDTO.getUserName() != null) {
			user.setUserName(userDTO.getUserName());
			System.out.println("inside set name");
		}
		if (userDTO.getEmail() != null) {
			user.setEmail(userDTO.getEmail());
			System.out.println("inside set emil");
		}
		if (userDTO.getPassword() != null) {
			user.setPassword(userDTO.getPassword());
		}
		if (userDTO.getAbout() != null) {
			user.setAbout(userDTO.getAbout());
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
