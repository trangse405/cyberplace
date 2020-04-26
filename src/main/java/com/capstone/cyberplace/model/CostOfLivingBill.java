package com.capstone.cyberplace.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CostOfLivingBill")
public class CostOfLivingBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "col_id", nullable = false)
	private int colID;

	@Column(name = "contract_id", nullable = false)
	private int contractID;

	@Column(name = "date_collect", nullable = false)
	private Date dateCollect;

	@Column(name = "total_expense", nullable = false)
	private float totalExpense;

	@Column(name = "bill_status_id", nullable = false)
	private int paymentStatusID;

	public CostOfLivingBill() {
		// TODO Auto-generated constructor stub
	}

	public CostOfLivingBill(int colID, int contractID, Date dateCollect, float totalExpense, int paymentStatusID) {
		super();
		this.colID = colID;
		this.contractID = contractID;
		this.dateCollect = dateCollect;
		this.totalExpense = totalExpense;
		this.paymentStatusID = paymentStatusID;
	}

	public int getColID() {
		return colID;
	}

	public void setColID(int colID) {
		this.colID = colID;
	}

	public int getContractID() {
		return contractID;
	}

	public void setContractID(int contractID) {
		this.contractID = contractID;
	}

	public Date getDateCollect() {
		return dateCollect;
	}

	public void setDateCollect(Date dateCollect) {
		this.dateCollect = dateCollect;
	}

	public float getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}

	public int getPaymentStatusID() {
		return paymentStatusID;
	}

	public void setPaymentStatusID(int paymentStatusID) {
		this.paymentStatusID = paymentStatusID;
	}

}
