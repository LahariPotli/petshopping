package com.demo.petshopping.serviceimpl;

import java.util.Optional;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.demo.petshopping.dao.UserDao;
import com.demo.petshopping.dto.LoginDto;
import com.demo.petshopping.dto.LoginResponseDto;
import com.demo.petshopping.exception.InvalidCredentialsException;
import com.demo.petshopping.model.User;
import com.demo.petshopping.service.UserService;


/**
 * @author Lahari_Reddy
 *
 */
@Service
public class UserServiceImpl implements UserService {
	static Log logger = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	UserDao userDao;
	/**
	 *{@Inherit doc}
	 */
	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		logger.info("inside user login serviceimpl");
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		
		
		Optional<User> userOptional  = userDao.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
		
		
		
		if(!userOptional.isPresent())
		{
			throw new InvalidCredentialsException("User not found ");
		}
			loginResponseDto.setMessage("User logged in successfully");
			loginResponseDto.setStatusCode(HttpStatus.OK.value());
			return loginResponseDto;
			
		
	}
	
	

}
