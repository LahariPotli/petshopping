package com.demo.petshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Generates Pets table with petId,petName,price
 * @author Lahari_Reddy
 *
 */

@Entity
public class Pets {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int petId;
	private String petName;
	private double price;

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
