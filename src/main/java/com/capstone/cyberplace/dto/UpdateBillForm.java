package com.capstone.cyberplace.dto;

public class UpdateBillForm {

	private int colId;
	private int costId;
	private float amount;
	private int unitID;
	private float totalExpense;

	public UpdateBillForm() {
		// TODO Auto-generated constructor stub
	}

	public float getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}

	public int getColId() {
		return colId;
	}

	public void setColId(int colId) {
		this.colId = colId;
	}

	public int getCostId() {
		return costId;
	}

	public void setCostId(int costId) {
		this.costId = costId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

}
