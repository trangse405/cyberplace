package com.capstone.cyberplace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderStatus")
public class OrderStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_status_id", nullable = false)
	private int orderStatusID;

	@Column(name = "order_status_name", nullable = false)
	private String orderStatusName;

	public OrderStatus() {
		
	}

	public OrderStatus(int orderStatusID, String orderStatusName) {
		super();
		this.orderStatusID = orderStatusID;
		this.orderStatusName = orderStatusName;
	}

	public int getOrderStatusID() {
		return orderStatusID;
	}

	public void setOrderStatusID(int orderStatusID) {
		this.orderStatusID = orderStatusID;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

}
