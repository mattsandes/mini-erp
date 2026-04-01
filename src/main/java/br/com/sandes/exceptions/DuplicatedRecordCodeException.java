package br.com.sandes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedProductCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicatedProductCodeException(String message) {
		super(message);
	}
	
	public DuplicatedProductCodeException() {
		super("There is already a product registered with the same code.");
	}
}
