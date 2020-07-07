package com.demo.petshopping.exception;

public class InvalidPetIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidPetIdException(String exception) {
		super(exception);
	}

}
