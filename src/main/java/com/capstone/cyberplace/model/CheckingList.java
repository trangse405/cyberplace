package com.capstone.cyberplace.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CheckingList")
public class CheckingList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checking_id", nullable = false)
	private int checkingID;

	@Column(name = "place_id")
	private int placeID;

	@Column(name = "staff_id")
	private Integer staffID;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "checking_status_id")
	private int checkingStatusID;

	public CheckingList() {
		// TODO Auto-generated constructor stub
	}

	public CheckingList(int checkingID, int placeID, int staffID, Date dateTime, int checkingStatusID) {
		super();
		this.checkingID = checkingID;
		this.placeID = placeID;
		this.staffID = staffID;
		this.dateTime = dateTime;
		this.checkingStatusID = checkingStatusID;
	}

	public int getCheckingID() {
		return checkingID;
	}

	public void setCheckingID(int checkingID) {
		this.checkingID = checkingID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public Integer getStaffID() {
		return staffID;
	}

	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getCheckingStatusID() {
		return checkingStatusID;
	}

	public void setCheckingStatusID(int checkingStatusID) {
		this.checkingStatusID = checkingStatusID;
	}

}
