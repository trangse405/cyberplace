package com.capstone.cyberplace.dto.form;

public class InsertedContractForm {

	private int ownerID;
	private int renterID;
	private int placeID;

	private String startDate;
	private String endDate;
	private float fee;
	private int contractStatusID;

	public InsertedContractForm() {
		// TODO Auto-generated constructor stub
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getRenterID() {
		return renterID;
	}

	public void setRenterID(int renterID) {
		this.renterID = renterID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getContractStatusID() {
		return contractStatusID;
	}

	public void setContractStatusID(int contractStatusID) {
		this.contractStatusID = contractStatusID;
	}

}
