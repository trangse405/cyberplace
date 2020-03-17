package com.capstone.cyberplace.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CostOfLivingManagement")
public class CostOfLivingManagement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "col_id", nullable = false)
	private int COLID;
	
	
	@Column(name = "contract_id", nullable = false)
	private int contractID;
	

	@Column(name = "month", nullable = false)
	private Date month;
	
	
	

	@Column(name = "power_number", nullable = false)
	private int powerNumber;
	
	@Column(name = "power_unit_price", nullable = false)
	private float powerUnitPrice;
	
	@Column(name = "water_number", nullable = false)
	private int waterNumber;
	
	@Column(name = "water_unit_price", nullable = false)
	private float waterUnitPrice;
	
	@Column(name = "internet", nullable = false)
	private float internet;
	
	@Column(name = "fee", nullable = false)
	private float fee;
	
	
	@Column(name = "total_money", nullable = false)
	private float totalMoney;
	
	
	@Column(name = "payment_status_id", nullable = false)
	private int paymentStatusID;
	
	public CostOfLivingManagement() {
		// TODO Auto-generated constructor stub
	}

	public CostOfLivingManagement(int cOLID, int contractID, Date month, int powerNumber, float powerUnitPrice,
			int waterNumber, float waterUnitPrice, float internet, float fee, float totalMoney, int paymentStatusID) {
		super();
		COLID = cOLID;
		this.contractID = contractID;
		this.month = month;
		this.powerNumber = powerNumber;
		this.powerUnitPrice = powerUnitPrice;
		this.waterNumber = waterNumber;
		this.waterUnitPrice = waterUnitPrice;
		this.internet = internet;
		this.fee = fee;
		this.totalMoney = totalMoney;
		this.paymentStatusID = paymentStatusID;
	}

	public int getCOLID() {
		return COLID;
	}

	public void setCOLID(int cOLID) {
		COLID = cOLID;
	}

	public int getContractID() {
		return contractID;
	}

	public void setContractID(int contractID) {
		this.contractID = contractID;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public int getPowerNumber() {
		return powerNumber;
	}

	public void setPowerNumber(int powerNumber) {
		this.powerNumber = powerNumber;
	}

	public float getPowerUnitPrice() {
		return powerUnitPrice;
	}

	public void setPowerUnitPrice(float powerUnitPrice) {
		this.powerUnitPrice = powerUnitPrice;
	}

	public int getWaterNumber() {
		return waterNumber;
	}

	public void setWaterNumber(int waterNumber) {
		this.waterNumber = waterNumber;
	}

	public float getWaterUnitPrice() {
		return waterUnitPrice;
	}

	public void setWaterUnitPrice(float waterUnitPrice) {
		this.waterUnitPrice = waterUnitPrice;
	}

	public float getInternet() {
		return internet;
	}

	public void setInternet(float internet) {
		this.internet = internet;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getPaymentStatusID() {
		return paymentStatusID;
	}

	public void setPaymentStatusID(int paymentStatusID) {
		this.paymentStatusID = paymentStatusID;
	}
	
	
	
	
	
	

}
