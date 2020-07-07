package com.demo.petshopping.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.petshopping.dto.LoginDto;
import com.demo.petshopping.dto.LoginResponseDto;
import com.demo.petshopping.service.UserService;

/**
 * @authorLahari_Reddy This controller validate userlogin
 *
 */
@RestController
public class UserController {
	static Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * @param loginDto
	 * @return message status code based on validation
	 */

	@PostMapping("/users/login")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto loginDto) {
		logger.info("Inside login user controller");
		return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
	}

}
