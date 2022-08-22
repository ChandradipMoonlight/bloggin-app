package com.blog.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentInputDTO {

	private String CommentContent;

	private String commenterName;

	private String commenterEmail;
}
