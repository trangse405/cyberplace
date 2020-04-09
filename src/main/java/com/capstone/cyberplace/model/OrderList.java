package com.capstone.cyberplace.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderList")
public class OrderList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private int orderID;

	@Column(name = "orderer_id", nullable = false)
	private int ordererID;

	@Column(name = "place_id", nullable = false)
	private int placeID;

	@Column(name = "order_status_id", nullable = false)
	private int orderStatusID;

	@Column(name = "date_time", nullable = false)
	private Date dateTime;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone_number", nullable = false)
	private String phone_number;

	@Column(name = "message", nullable = false)
	private String message;

	public OrderList() {
		// TODO Auto-generated constructor stub
	}

	public OrderList(int orderID, int ordererID, int placeID, int orderStatusID, Date dateTime, String name,
			String email, String phone_number, String message) {
		super();
		this.orderID = orderID;
		this.ordererID = ordererID;
		this.placeID = placeID;

		this.orderStatusID = orderStatusID;
		this.dateTime = dateTime;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.message = message;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getOrdererID() {
		return ordererID;
	}

	public void setOrdererID(int ordererID) {
		this.ordererID = ordererID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public int getOrderStatusID() {
		return orderStatusID;
	}

	public void setOrderStatusID(int orderStatusID) {
		this.orderStatusID = orderStatusID;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
