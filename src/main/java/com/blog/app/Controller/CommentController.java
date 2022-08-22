package com.blog.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.builder.MessageProperties;
import com.blog.app.dto.CommentInputDTO;
import com.blog.app.dto.ResponseDTO;
import com.blog.app.service.ICommentsService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private ICommentsService commentService;
	
	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<ResponseDTO> addComment(@PathVariable("postId") Integer postId, @RequestBody CommentInputDTO commentInputDTO){
		ResponseDTO response = new ResponseDTO(MessageProperties.COMMENT_ADDED.getMessage(), 
				commentService.createComment(postId, commentInputDTO));
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable("commentId") Integer commentId){
		String delete = commentService.deleteComment(commentId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
