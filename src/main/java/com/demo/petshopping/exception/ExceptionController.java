package com.demo.petshopping.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = PetNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(PetNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Requested petname is not found");
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(600);
		String allErrors = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.joining(","));
		errorResponse.setMessage(allErrors);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> exception(InvalidCredentialsException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("user not found");
		errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(value = InvalidUserIdException.class)
	public ResponseEntity<ErrorResponse> exception(InvalidUserIdException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("no pets are purchased by this userId.");
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = AlreadyPurchasedException.class)
	public ResponseEntity<ErrorResponse> exception(AlreadyPurchasedException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("you have already purchased this pet.please select other one.");
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = InvalidPetIdException.class)
	public ResponseEntity<ErrorResponse> exception(InvalidPetIdException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("pet with this pet Id is not there.");
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = UserIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(UserIdNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("User with this user Id is not found.");
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	

	


}
