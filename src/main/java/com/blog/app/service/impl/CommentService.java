package com.blog.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.builder.MessageProperties;
import com.blog.app.dto.CommentDTO;
import com.blog.app.dto.CommentInputDTO;
import com.blog.app.enitity.Comment;
import com.blog.app.enitity.Post;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.repositories.CommentRepo;
import com.blog.app.repositories.PostRepo;
import com.blog.app.service.ICommentsService;

@Service
public class CommentService implements ICommentsService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDTO createComment(Integer postId, CommentInputDTO commentInputDTO) {
		Post post = postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));
		Comment comment = modelMapper.map(commentInputDTO, Comment.class);
		comment.setPost(post);
		Comment save = commentRepo.save(comment);
		return modelMapper.map(save, CommentDTO.class);
	}

	@Override
	public String deleteComment(Integer commentId) {
		Comment comment = commentRepo.findById(commentId)
				.orElseThrow(()->new ResourceNotFoundException("Comment", "CommentId", commentId));
		commentRepo.delete(comment);
		return MessageProperties.COMMENT_DELETED.getMessage();
	}

}
