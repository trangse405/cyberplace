package com.capstone.cyberplace.dto.form;

public class CostOfPlaceForm {

	private String costName;
	private float costPrice;
	private int unitID;

	public CostOfPlaceForm() {
		// TODO Auto-generated constructor stub
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

}
