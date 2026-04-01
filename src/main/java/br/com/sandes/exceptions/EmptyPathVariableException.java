package br.com.sandes.exceptions;

public class EmptyPathVariableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyPathVariableException() {
		super("Path variabel cannot be empty");
	}
}
