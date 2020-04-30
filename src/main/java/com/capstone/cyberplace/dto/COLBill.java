package com.capstone.cyberplace.dto;

import java.util.List;

public class COLBill {

	private int colId;
	private int contractId;
	private int renterId;
	private int ownerID;
	private int placeId;
	private String dateCollect;
	private float totalExpense;
	private int paymentStatusId;
	private String paymentStatusName;
	private String cashPaidLink;
	private List<COLBillDetail> colBillDetails;

	// tien nha
	private float placePrice;

	public COLBill() {

	}

	public String getCashPaidLink() {
		return cashPaidLink;
	}

	public void setCashPaidLink(String cashPaidLink) {
		this.cashPaidLink = cashPaidLink;
	}

	public int getColId() {
		return colId;
	}

	public void setColId(int colId) {
		this.colId = colId;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getRenterId() {
		return renterId;
	}

	public void setRenterId(int renterId) {
		this.renterId = renterId;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getDateCollect() {
		return dateCollect;
	}

	public void setDateCollect(String dateCollect) {
		this.dateCollect = dateCollect;
	}

	public float getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}

	public int getPaymentStatusId() {
		return paymentStatusId;
	}

	public void setPaymentStatusId(int paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

	public String getPaymentStatusName() {
		return paymentStatusName;
	}

	public void setPaymentStatusName(String paymentStatusName) {
		this.paymentStatusName = paymentStatusName;
	}

	public float getPlacePrice() {
		return placePrice;
	}

	public void setPlacePrice(float placePrice) {
		this.placePrice = placePrice;
	}

	public List<COLBillDetail> getColBillDetails() {
		return colBillDetails;
	}

	public void setColBillDetails(List<COLBillDetail> colBillDetails) {
		this.colBillDetails = colBillDetails;
	}

}
