package com.demo.petshopping.service;

import javax.validation.Valid;

import com.demo.petshopping.dto.LoginDto;
import com.demo.petshopping.dto.LoginResponseDto;



public interface UserService {
	/**this method is used to login user
	 * @param loginDto
	 * @return login user
	 */
	public LoginResponseDto loginUser(@Valid LoginDto loginDto);

}
