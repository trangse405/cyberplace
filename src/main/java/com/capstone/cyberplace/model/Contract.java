package com.capstone.cyberplace.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contract")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id", nullable = false)
	private int contractID;

	@Column(name = "owner_id", nullable = false)
	private int ownerID;

	@Column(name = "renter_id", nullable = false)
	private int renterID;

	@Column(name = "place_id")
	private int placeID;
	@Column(name = "order_id")
	private Integer orderID;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "fee", nullable = false)
	private float fee;

	@Column(name = "contract_status_id")
	private int contractStatusID;
	
	@Column(name = "is_use_service")
	private Integer isUseService;

	@Column(name = "contract_link")
	private String contractLink;

	public Contract() {
		// TODO Auto-generated constructor stub
	}

	public Contract(int contractID, int ownerID, int renterID, int placeID, Integer orderID, Date startDate,
			Date endDate, float fee, int contractStatusID, Integer isUseService, String contractLink) {
		super();
		this.contractID = contractID;
		this.ownerID = ownerID;
		this.renterID = renterID;
		this.placeID = placeID;
		this.orderID = orderID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fee = fee;
		this.contractStatusID = contractStatusID;
		this.isUseService = isUseService;
		this.contractLink = contractLink;
	}

	public Integer getIsUseService() {
		return isUseService;
	}

	public void setIsUseService(Integer isUseService) {
		this.isUseService = isUseService;
	}

	public String getContractLink() {
		return contractLink;
	}

	public void setContractLink(String contractLink) {
		this.contractLink = contractLink;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

}
