package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.capstone.cyberplace.model.id.CostOfLivingBillDetailID;

@Entity
@Table(name = "CostOfLivingBillDetail")
@IdClass(CostOfLivingBillDetailID.class)
public class CostOfLivingBillDetail {

	@Id
	@Column(name = "col_id", nullable = false)
	private int colID;
	
	@Id
	@Column(name = "cost_of_place_id", nullable = false)
	private int costOfPlaceID;

	@Column(name = "amount")
	private float amount;

	@Column(name = "expense_per_cost")
	private float expensePerCost;

	public CostOfLivingBillDetail() {
		// TODO Auto-generated constructor stub
	}

	public CostOfLivingBillDetail(int colID, int costOfPlaceID, float amount, float expensePerCost) {
		super();
		this.colID = colID;
		this.costOfPlaceID = costOfPlaceID;
		this.amount = amount;
		this.expensePerCost = expensePerCost;
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

}
