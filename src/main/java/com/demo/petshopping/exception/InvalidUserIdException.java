package com.demo.petshopping.exception;

public class InvalidUserIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidUserIdException(String exception) {
		super(exception);
	}


}
