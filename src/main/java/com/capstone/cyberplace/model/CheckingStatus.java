package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CheckingStatus")
public class CheckingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checking_status_id", nullable = false)
	private int checkingStatusID;

	@Column(name = "checking_status_name", nullable = false)
	private String checkingStatusName;

	public CheckingStatus() {
		// TODO Auto-generated constructor stub
	}

	public CheckingStatus(int checkingStatusID, String checkingStatusName) {
		super();
		this.checkingStatusID = checkingStatusID;
		this.checkingStatusName = checkingStatusName;
	}

	public int getCheckingStatusID() {
		return checkingStatusID;
	}

	public void setCheckingStatusID(int checkingStatusID) {
		this.checkingStatusID = checkingStatusID;
	}

	public String getCheckingStatusName() {
		return checkingStatusName;
	}

	public void setCheckingStatusName(String checkingStatusName) {
		this.checkingStatusName = checkingStatusName;
	}

}
