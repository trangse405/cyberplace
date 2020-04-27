package com.capstone.cyberplace.model.id;

import java.io.Serializable;

public class CostOfLivingBillDetailID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int colID;

	private int costOfPlaceID;

	public CostOfLivingBillDetailID() {
		// TODO Auto-generated constructor stub
	}

	public CostOfLivingBillDetailID(int colID, int costOfPlaceID) {
		super();
		this.colID = colID;
		this.costOfPlaceID = costOfPlaceID;
	}

	public int getColID() {
		return colID;
	}

	public void setColID(int colID) {
		this.colID = colID;
	}

	public int getCostOfPlaceID() {
		return costOfPlaceID;
	}

	public void setCostOfPlaceID(int costOfPlaceID) {
		this.costOfPlaceID = costOfPlaceID;
	}

}
