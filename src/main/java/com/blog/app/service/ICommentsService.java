package com.blog.app.service;

import com.blog.app.dto.CommentDTO;
import com.blog.app.dto.CommentInputDTO;

public interface ICommentsService {
	
	CommentDTO createComment(Integer postId, CommentInputDTO commentDTO);
	
	String deleteComment(Integer commentId );

}
