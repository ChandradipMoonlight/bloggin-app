package com.blog.app.exception;

public class UserException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public enum ExceptionType{
		USER_ALREADY_PRESENT,
	}
	private String message;
	
	public UserException.ExceptionType type;
	
	public UserException(String msg) {
		this.message=msg;
	}
	
	public UserException(String message, UserException.ExceptionType type) {
		super(message);
		this.type=type;
	}
}
