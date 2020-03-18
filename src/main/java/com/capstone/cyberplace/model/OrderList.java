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

	@Column(name = "staff_id", nullable = false)
	private int staffID;

	@Column(name = "order_status_id", nullable = false)
	private int orderStatusID;

	@Column(name = "date_time", nullable = false)
	private Date dateTime;

	public OrderList() {
		// TODO Auto-generated constructor stub
	}

	public OrderList(int orderID, int ordererID, int placeID, int staffID, int orderStatusID, Date dateTime) {
		super();
		this.orderID = orderID;
		this.ordererID = ordererID;
		this.placeID = placeID;
		this.staffID = staffID;
		this.orderStatusID = orderStatusID;
		this.dateTime = dateTime;
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

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
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

}
