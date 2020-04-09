package com.capstone.cyberplace.dto.form;

public class ChangeStatusCheckingForm {
	private int checkingID;
	private int statusCheckingID;
	private int placeID;
	private int statusPlaceID;

	public ChangeStatusCheckingForm() {
		// TODO Auto-generated constructor stub
	}

	public int getCheckingID() {
		return checkingID;
	}

	public void setCheckingID(int checkingID) {
		this.checkingID = checkingID;
	}

	public int getStatusCheckingID() {
		return statusCheckingID;
	}

	public void setStatusCheckingID(int statusCheckingID) {
		this.statusCheckingID = statusCheckingID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public int getStatusPlaceID() {
		return statusPlaceID;
	}

	public void setStatusPlaceID(int statusPlaceID) {
		this.statusPlaceID = statusPlaceID;
	}

}
