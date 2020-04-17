package com.capstone.cyberplace.dto.form;

public class ManageContractForm {
	private int contractID;
	private int ownerID;
	private int renterID;
	private int placeID;
	private Integer orderID;
	private String placeStatus;
	private String startDate;
	private String endDate;
	private float fee;
	private int contractStatusID;
	private String statusContract;
	private int placeStatusID;
	private String titlePlace;

	public ManageContractForm() {
		// TODO Auto-generated constructor stub
	}

	public int getContractID() {
		return contractID;
	}

	public void setContractID(int contractID) {
		this.contractID = contractID;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getRenterID() {
		return renterID;
	}

	public void setRenterID(int renterID) {
		this.renterID = renterID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getContractStatusID() {
		return contractStatusID;
	}

	public void setContractStatusID(int contractStatusID) {
		this.contractStatusID = contractStatusID;
	}

	public String getStatusContract() {
		return statusContract;
	}

	public void setStatusContract(String statusContract) {
		this.statusContract = statusContract;
	}

	public String getTitlePlace() {
		return titlePlace;
	}

	public void setTitlePlace(String titlePlace) {
		this.titlePlace = titlePlace;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getPlaceStatus() {
		return placeStatus;
	}

	public void setPlaceStatus(String placeStatus) {
		this.placeStatus = placeStatus;
	}

	public int getPlaceStatusID() {
		return placeStatusID;
	}

	public void setPlaceStatusID(int placeStatusID) {
		this.placeStatusID = placeStatusID;
	}

}
