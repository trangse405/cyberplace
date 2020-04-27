package com.capstone.cyberplace.dto;

import java.util.List;

public class COLBillUpdate {

	private float totalExpense;
	private List<COLBillDetail> colBillDetails;

	public COLBillUpdate() {
		// TODO Auto-generated constructor stub
	}

	public float getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}

	public List<COLBillDetail> getColBillDetails() {
		return colBillDetails;
	}

	public void setColBillDetails(List<COLBillDetail> colBillDetails) {
		this.colBillDetails = colBillDetails;
	}

}
