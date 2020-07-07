package com.demo.petshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.petshopping.dto.BookingResponseDto;
import com.demo.petshopping.dto.ConfirmationListResponseDto;
import com.demo.petshopping.dto.OrderRequestDto;
import com.demo.petshopping.service.ConfirmationService;

/**
 * @author Lahari_Reddy 
 * This controller is used to get all pet details bBY
 *         userId and to buy an pet.
 *
 */
@RestController
public class ConfirmationController {
	static Log logger = LogFactory.getLog(ConfirmationController.class);
	@Autowired
	ConfirmationService confirmationService;

	/**
	 * @param userId
	 * @return history of pet details by userid
	 */
	@GetMapping("/users/{userId}/confirmation")
	public ResponseEntity<ConfirmationListResponseDto> petDetails(@PathVariable("userId") Integer userId) {
		logger.info("Inside getpetdetails method in controller");
		return new ResponseEntity<>(confirmationService.getPetsByUserId(userId), HttpStatus.OK);
	}

	/**
	 * @param orderRequestDto
	 * @param userId
	 * @return buying an pet
	 */
	@PostMapping("/bookings/{userId}")
	public ResponseEntity<BookingResponseDto> buyAnPet(@RequestBody OrderRequestDto orderRequestDto,
			@PathVariable("userId") Integer userId) {
		logger.info("Inside buyAnPet method in controller");
		return new ResponseEntity<>(confirmationService.buyPet(orderRequestDto, userId), HttpStatus.OK);
	}
}