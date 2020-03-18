package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentStatus")
public class PaymentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_status_id", nullable = false)
	private int paymentStatusID;

	@Column(name = "payment_status_name", nullable = false)
	private String paymentStatusName;

	public PaymentStatus() {
		// TODO Auto-generated constructor stub
	}

	public PaymentStatus(int paymentStatusID, String paymentStatusName) {
		super();
		this.paymentStatusID = paymentStatusID;
		this.paymentStatusName = paymentStatusName;
	}

	public int getPaymentStatusID() {
		return paymentStatusID;
	}

	public void setPaymentStatusID(int paymentStatusID) {
		this.paymentStatusID = paymentStatusID;
	}

	public String getPaymentStatusName() {
		return paymentStatusName;
	}

	public void setPaymentStatusName(String paymentStatusName) {
		this.paymentStatusName = paymentStatusName;
	}

}
