package com.blog.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.builder.MessageProperties;
import com.blog.app.dto.ResponseDTO;
import com.blog.app.dto.UserDTO;
import com.blog.app.enitity.User;
import com.blog.app.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO userDTO) {
		ResponseDTO response = new ResponseDTO(MessageProperties.REGISTRATION_SUCCESSFUL.getMessage(),
				userService.createUser(userDTO));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<ResponseDTO> getAllUsers() {
		List<UserDTO> userlist = userService.getAllUsers();
		ResponseDTO response = new ResponseDTO(MessageProperties.FETCH_ALL_USERS.getMessage(), userlist);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<ResponseDTO> getuserById(@PathVariable("userId") Integer userId) {
		ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_USER.getMessage(),
				userService.getUserById(userId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<ResponseDTO> updateUserById(@PathVariable("userId") Integer userId,
			@RequestBody UserDTO userDTO) {
		ResponseDTO response = new ResponseDTO(MessageProperties.UPDATEED_USER.getMessage(),
				userService.updateUser(userDTO, userId));
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUseById(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
	}

}
