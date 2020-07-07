package com.demo.petshopping.dto;

/**
 * @author Lahari_Reddy
 *
 */

public class PetResponseDto {
	
	private int petId;
	private String petName;
	private double price;
	private String petColour;

	public String getPetColour() {
		return petColour;
	}

	public void setPetColour(String petColour) {
		this.petColour = petColour;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
