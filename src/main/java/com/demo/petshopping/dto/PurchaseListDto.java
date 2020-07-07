package com.demo.petshopping.dto;
/**
 * @author Lahari_Reddy
 *
 */

public class PurchaseListDto {
	 private String petName;
	    private double Price;
	    public String getPetName() {
	        return petName;
	    }
	    public void setPetName(String petName) {
	        this.petName = petName;
	    }
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		
}
