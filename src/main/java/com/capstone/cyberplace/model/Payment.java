package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "user_id", nullable = false)
	private int userID;

	@Column(name = "place_id", nullable = false)
	private int placeID;

	@Column(name = "create_time", nullable = false)
	private String createTime;

	@Column(name = "status", nullable = false)
	private String status;
	@Column(name = "payer_id", nullable = false)
	private String payerID;
	@Column(name = "money", nullable = false)
	private float money;
	@Column(name = "description")
	private String description;

	@Column(name = "order_id")
	private String orderID;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Payment(int id, int userID, int placeID, String createTime, String status, String payerID, float money,
			String description, String orderID) {
		super();
		this.id = id;
		this.userID = userID;
		this.placeID = placeID;
		this.createTime = createTime;
		this.status = status;
		this.payerID = payerID;
		this.money = money;
		this.description = description;
		this.orderID = orderID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayerID() {
		return payerID;
	}

	public void setPayerID(String payerID) {
		this.payerID = payerID;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

}
