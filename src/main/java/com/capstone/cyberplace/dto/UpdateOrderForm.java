package com.capstone.cyberplace.dto;

public class UpdateOrderForm {

	private int orderID;
	private String dateTime;
	private String name;
	private String email;
	private String phoneNumber;
	private String message;

	public UpdateOrderForm() {
		// TODO Auto-generated constructor stub
	}

	public UpdateOrderForm(int orderID, String dateTime, String name, String email, String phoneNumber,
			String message) {
		super();
		this.orderID = orderID;
		this.dateTime = dateTime;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
