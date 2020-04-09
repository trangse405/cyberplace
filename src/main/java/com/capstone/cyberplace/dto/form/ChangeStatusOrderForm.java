package com.capstone.cyberplace.dto.form;

public class ChangeStatusOrderForm {

	private int orderID;
	private int statusOrderID;
	private int placeID;
	private int statusPlaceID;

	public ChangeStatusOrderForm() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getStatusOrderID() {
		return statusOrderID;
	}

	public void setStatusOrderID(int statusOrderID) {
		this.statusOrderID = statusOrderID;
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
