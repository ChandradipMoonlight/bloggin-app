package com.blog.app.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String filedName;
	private Integer fieldValue;
	private String message;
	public ResourceNotFoundException(String resourceName, String filedName, Integer fieldValue) {
		super(String.format("%s not found with %s : %d", resourceName, filedName, fieldValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.fieldValue = fieldValue;
	}
}
