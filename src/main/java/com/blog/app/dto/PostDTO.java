package com.blog.app.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	
	private Set<CommentDTO> comments = new HashSet<>();
	
	private LocalDate createdDate;
}
