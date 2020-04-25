package com.capstone.cyberplace.dto;

public class COLBillDetail {

	private int colId;
	private int costId;
	private float amount;
	private float expensePerCost;
	private String costName;
	private float costPrice;
	private String unitName;

	public COLBillDetail() {

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

	public float getExpensePerCost() {
		return expensePerCost;
	}

	public void setExpensePerCost(float expensePerCost) {
		this.expensePerCost = expensePerCost;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
