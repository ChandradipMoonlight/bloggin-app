package com.blog.app.service;

import java.util.List;

import com.blog.app.dto.PostDTO;
import com.blog.app.dto.PostInputDTO;
import com.blog.app.dto.PostResponse;

public interface IPostService {

	PostDTO createPost(PostInputDTO postInputDTO, Integer userId, Integer categoryId);
	
	PostDTO updatePost(Integer postId, PostInputDTO postInputDTO);
	
	String deletePost(Integer postId);
	
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String orderBy);
	
	PostDTO getPostById(Integer postId);
	
	List<PostDTO> getAllPostsByCategory(Integer categoryId);
	
	List<PostDTO> getAllPostsByUser(Integer userId);
	
	List<PostDTO> searchPostByTitle(String key);
}
