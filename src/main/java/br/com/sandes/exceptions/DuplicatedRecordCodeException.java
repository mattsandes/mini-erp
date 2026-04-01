package br.com.sandes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedRecordCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicatedRecordCodeException(String message) {
		super(message);
	}
	
	public DuplicatedRecordCodeException() {
		super("There is already a record registered with the same code.");
	}
}
