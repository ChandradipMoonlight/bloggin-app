package com.blog.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.enitity.Category;
import com.blog.app.enitity.Post;
import com.blog.app.enitity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
}
