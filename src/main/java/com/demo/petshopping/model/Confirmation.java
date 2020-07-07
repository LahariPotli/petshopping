package com.demo.petshopping.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Generates Confirmation table with confirmationId, userId,petId,date.
 * @author Lahari_Reddy
 *
 */

@Entity
public class Confirmation {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int confirmationId;

	public int getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(int confirmationId) {
		this.confirmationId = confirmationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	private int userId;
	private int petId;
	private LocalDate date;

}
