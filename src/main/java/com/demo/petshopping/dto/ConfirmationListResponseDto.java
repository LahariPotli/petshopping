package com.demo.petshopping.dto;

import java.util.List;

/**
 * @author Lahari_Reddy
 *
 */
public class ConfirmationListResponseDto {
	private String message;
	private Integer statusCode;
	List<PurchaseListDto> purchaseListDto;

	public List<PurchaseListDto> getPurchaseListDto() {
		return purchaseListDto;
	}

	public void setPurchaseListDto(List<PurchaseListDto> purchaseListDto) {
		this.purchaseListDto = purchaseListDto;
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
