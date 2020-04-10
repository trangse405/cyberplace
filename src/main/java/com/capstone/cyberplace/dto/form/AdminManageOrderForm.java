package com.capstone.cyberplace.dto.form;

public class AdminManageOrderForm {

	private int orderID;
	private String contactName;
	private String name;
	private String email;
	private String phoneNumber;
	private String dateTime;
	private String address;
	private String message;
	private String status;
	private int placeID;
	private String statusPlace;
	private int statusPlaceID;

	public AdminManageOrderForm() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
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

}
