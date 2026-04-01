package br.com.sandes.handlers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.sandes.exceptions.DuplicatedRecordCodeException;
import br.com.sandes.exceptions.ExceptionResponse;
import br.com.sandes.exceptions.RequiredObjectNullException;
import br.com.sandes.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ProductExceptionHandlder extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	private final ResponseEntity<ExceptionResponse> handleInteralServerErrorException (
			Exception ex, WebRequest request) {
		
		ExceptionResponse response = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({
		ResourceNotFoundException.class,
		DuplicatedRecordCodeException.class,
		RequiredObjectNullException.class
	})
	private final ResponseEntity<ExceptionResponse> handleBadRequestException (
			Exception ex, WebRequest request) {
		
		ExceptionResponse response = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
