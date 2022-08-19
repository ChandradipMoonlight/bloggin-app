package com.blog.app.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.app.enitity.Category;
import com.blog.app.enitity.Post;
import com.blog.app.enitity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByPostTitleContaining(String postTitle);
	//or else we can user JPQL query
	
	@Query("Select p from Post p where p.postTitle like : key")
	List<Post> searchByTitle(@Param("key") String postTitle);
	//ex -> %postTitle% ==> key
	
	List<Post> findByPostContent(String postContent);
	
	List<Post> findByCreatedDate(LocalDate createdDate);
}
