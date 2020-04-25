package com.capstone.cyberplace.dto;

public class UpdateBillForm {

	private int colID;
	private int costOfPlaceID;
	private float amount;

	public UpdateBillForm() {
		// TODO Auto-generated constructor stub
	}

	public int getColID() {
		return colID;
	}

	public void setColID(int colID) {
		this.colID = colID;
	}

	public int getCostOfPlaceID() {
		return costOfPlaceID;
	}

	public void setCostOfPlaceID(int costOfPlaceID) {
		this.costOfPlaceID = costOfPlaceID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
