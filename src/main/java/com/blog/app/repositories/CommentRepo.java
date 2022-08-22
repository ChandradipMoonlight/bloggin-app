package com.blog.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.enitity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
