package com.blog.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.builder.MessageProperties;
import com.blog.app.dto.CategoryDTO;
import com.blog.app.enitity.Category;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.repositories.CategoryRepo;
import com.blog.app.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category save = categoryRepo.save(dtoToCategory(categoryDTO));
		return categoryToDto(save);
	}

	@Override
	public CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDTO) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		if (categoryDTO.getCategoryTitle()!=null) {
			category.setCategoryTitle(categoryDTO.getCategoryTitle());
		}
		if(categoryDTO.getCategoryDiscription()!=null) {
			category.setCategoryDiscription(categoryDTO.getCategoryDiscription());
		}
		return categoryToDto(category);
	}

	@Override
	public String deleteCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		categoryRepo.delete(category);
		return MessageProperties.DELETED_CATEGORY.getMessage();
	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		return categoryToDto(category);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryDTO> categoryDtoList = categoryRepo.findAll().stream()
				.map(categories ->categoryToDto(categories))
				.collect(Collectors.toList());
		return categoryDtoList;
	}

	public Category dtoToCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}

	public CategoryDTO categoryToDto(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
}
