package br.com.sandes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectNullException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RequiredObjectNullException(String message) {
		super();
	}

	public RequiredObjectNullException() {
		super("It's not allowed to persist a null object");
	}
}
