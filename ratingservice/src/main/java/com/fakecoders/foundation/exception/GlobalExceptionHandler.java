package com.fakecoders.foundation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fakecoders.foundation.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		return new ResponseEntity<ApiResponse>(ApiResponse.builder()
		.message(ex.getMessage())
		.status(HttpStatus.NOT_FOUND.toString())
		.success(true)
		.build(),HttpStatus.NOT_FOUND);
	}

}
