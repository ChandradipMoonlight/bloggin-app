package com.blog.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Integer userId;
	
	@NotEmpty(message = "UserName Can Not Be Empty!")
	@Size(min = 4, message = "UserName Must be min of 4 Charactor")
	private String userName;
	
	@Email(message = "Email Adressw Is Not Valid!")
	private String email;

	@NotEmpty(message = "Password Can Not Be Empty!")
	@Size(min=3, max = 8, message = "Password must be min of 3 chars and max of 8 chars!")
	private String password;
	
	@NotEmpty(message = "About Can Not Be Empty!")
	private String about;
}
