package com.capstone.cyberplace.dto.form;

public class AdminManageCheckingForm {

	private int checkingID;
	private int placeID;
	private String userName;
	private String title;
	private String dateTime;
	private String phoneNumber;
	private String contactName;
	private String status;
	private String statusPlace;
	private int statusPlaceID;

	public AdminManageCheckingForm() {
		// TODO Auto-generated constructor stub
	}

	public String getStatusPlace() {
		return statusPlace;
	}

	public void setStatusPlace(String statusPlace) {
		this.statusPlace = statusPlace;
	}

	public int getStatusPlaceID() {
		return statusPlaceID;
	}

	public void setStatusPlaceID(int statusPlaceID) {
		this.statusPlaceID = statusPlaceID;
	}

	public int getCheckingID() {
		return checkingID;
	}

	public void setCheckingID(int checkingID) {
		this.checkingID = checkingID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
