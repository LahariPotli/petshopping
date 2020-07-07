package com.demo.petshopping.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.petshopping.dao.UserDao;
import com.demo.petshopping.dto.LoginDto;
import com.demo.petshopping.dto.LoginResponseDto;
import com.demo.petshopping.exception.InvalidCredentialsException;
import com.demo.petshopping.model.User;
import com.demo.petshopping.service.UserService;
import com.demo.petshopping.serviceimpl.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	

	LoginResponseDto loginResponseDto;

	@Mock
	UserService userService;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("lahari");
		loginDto.setPassword("reddy");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("User logged in");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		
		user.setPassword("reddy");
		user.setUserId(1);
		user.setUserName("lahari");

		assertThat(!(loginDto.getUserName().isEmpty() && loginDto.getPassword().isEmpty())).isTrue();

		when(userDao.findByUserNameAndPassword("lahari", "reddy")).thenReturn(Optional.of(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByUserNameAndPassword("lahari", "reddy");

	}
	@Test
	public void loginUserTest2() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("lahari");
		loginDto.setPassword("reddy");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("User logged in successfully");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		
		user.setPassword("reddy");
		user.setUserId(1);
		user.setUserName("lahari");

		assertThat(!(loginDto.getUserName().isEmpty() && loginDto.getPassword().isEmpty())).isTrue();

		when(userDao.findByUserNameAndPassword("lahari", "reddy")).thenReturn(Optional.ofNullable(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByUserNameAndPassword("lahari", "reddy");

	}

	@Test
	public void loginUserTest3() throws InvalidCredentialsException{
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("lahari");
		loginDto.setPassword("reddy");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("User logged in successfully");
		loginResponseDto.setStatusCode(200);

		User user = new User();
		
		user.setPassword("reddy");
		user.setUserId(1);
		user.setUserName("lahari");
		
		InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
	        userServiceImpl.loginUser(loginDto);
	    });
	 
	    String expectedMessage = "User not found";
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	}
	

}