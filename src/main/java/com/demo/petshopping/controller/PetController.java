package com.demo.petshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.petshopping.dto.PetListResponseDto;

import com.demo.petshopping.service.PetService;

/**
 * @author Lahari_Reddy This controller returns pets by petname
 */
@RestController
public class PetController {
	static Log logger = LogFactory.getLog(PetController.class);
	@Autowired
	PetService petService;

	/**
	 * @param petName
	 * @return list of pets by petname
	 */
	@GetMapping("/pets")
	public ResponseEntity<PetListResponseDto> getPetsByPetName(@RequestParam("petName") String petName) {
		logger.info("inside get pets by petname controller");
		return new ResponseEntity<>(petService.getPetsByPetName(petName), HttpStatus.OK);
	}

}
