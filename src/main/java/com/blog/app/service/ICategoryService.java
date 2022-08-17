package com.blog.app.service;

import java.util.List;

import com.blog.app.dto.CategoryDTO;

public interface ICategoryService {
	
	CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDTO);
	
	String deleteCategory(Integer categoryId);
	
	CategoryDTO getCategory(Integer categoryId);
	
	List<CategoryDTO> getAllCategory();
}
