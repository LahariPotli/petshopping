package com.demo.petshopping.exception;

public class InvalidCredentialsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(String exception) {
		super(exception);
	}


}
