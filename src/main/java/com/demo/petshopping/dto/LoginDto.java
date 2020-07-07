package com.demo.petshopping.dto;

import javax.validation.constraints.NotEmpty;
/**
 * @author Lahari_Reddy
 *
 */

public class LoginDto {
	@NotEmpty(message = "userName cannot be null")
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@NotEmpty(message = "password cannot be null")
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
