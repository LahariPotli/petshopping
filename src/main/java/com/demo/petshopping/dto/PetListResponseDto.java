package com.demo.petshopping.dto;

import java.util.List;
/**
 * @author Lahari_Reddy
 *
 */

public class PetListResponseDto {
	private String message;
    private Integer statusCode;
    List<PetResponseDto> reponselistDto;
    
    public List<PetResponseDto> getReponselistDto() {
		return reponselistDto;
	}
	public void setReponselistDto(List<PetResponseDto> reponselistDto) {
		this.reponselistDto = reponselistDto;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
