package com.api.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Exception Handling Controller For The Whole Application Working as Global
@ControllerAdvice
public class GlobalExceptionHandler 
{
	
	// Handling custom validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customVaidationErrorHandler(MethodArgumentNotValidException exception) 
	{
		ErrorDetails errorDetails = new ErrorDetails("Validation Error", exception.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}
