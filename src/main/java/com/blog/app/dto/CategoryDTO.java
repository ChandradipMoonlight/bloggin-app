package com.blog.app.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	private Integer categoryId;
	
	@NotEmpty(message = "Category can not be empty!")
	@Size(min = 4 , message = "size should be more than 4")
	private String categoryTitle;
	
	@NotEmpty(message = "Category Description can not be empty!")
	@Size(min = 10 , message = "size should be more than 9")
	private String categoryDiscription;
}
