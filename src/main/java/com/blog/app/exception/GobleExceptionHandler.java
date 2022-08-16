package com.blog.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.app.dto.ResponseDTO;

@RestControllerAdvice
public class GobleExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> globalExceptionHandler(Exception exception) {
		ResponseDTO responseDTO = new ResponseDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO> UserExceptionHandler(UserException exception) {
		ResponseDTO responseDTO = new ResponseDTO(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseDTO> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		ResponseDTO response = new ResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> response = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String fildName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			response.put(fildName, errorMessage);
		});
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
	}
}
