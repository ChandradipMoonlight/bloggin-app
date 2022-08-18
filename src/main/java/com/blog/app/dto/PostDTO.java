package com.blog.app.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO extends PostInputDTO{
	private Integer postId;
	
	private UserDTO user;
	
	private CategoryDTO category;
	
	private LocalDate createdDate;
}
