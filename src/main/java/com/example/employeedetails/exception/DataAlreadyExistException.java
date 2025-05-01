package com.example.employeedetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;


	@ExceptionHandler(value = DataAlreadyExistException.class)
	public ResponseEntity<Object> exception(DataAlreadyExistException exception) {
		return new ResponseEntity<>("Data already exists", HttpStatus.UNPROCESSABLE_ENTITY);
	}

	
	

}
