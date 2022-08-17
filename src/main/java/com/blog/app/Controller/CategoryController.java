package com.blog.app.Controller;

import java.util.List;

import javax.validation.Valid;

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
import com.blog.app.dto.CategoryDTO;
import com.blog.app.dto.ResponseDTO;
import com.blog.app.service.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<ResponseDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		ResponseDTO response = new ResponseDTO(MessageProperties.CREATED_CATEGORY.getMessage(),
				categoryService.createCategory(categoryDTO));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<ResponseDTO> updateCategory(@PathVariable("categoryId") Integer categoryId,@Valid @RequestBody CategoryDTO categoryDTO) {
		ResponseDTO response = new ResponseDTO(MessageProperties.UPDATED_CATEGORY.getMessage(), 
				categoryService.updateCategory(categoryId, categoryDTO));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<ResponseDTO> getCategory(@PathVariable("categoryId") Integer categoryId){
		ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_CATEGORY.getMessage(),
				categoryService.getCategory(categoryId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		return new ResponseEntity<String>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<ResponseDTO> getAllCategories(){
		List<CategoryDTO> categoryList = categoryService.getAllCategory();
		ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_ALL_CATEGORY.getMessage(),
				categoryList);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
}
