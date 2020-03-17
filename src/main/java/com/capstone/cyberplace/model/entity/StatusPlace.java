package com.capstone.cyberplace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StatusPlace")
public class StatusPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_place_id", nullable = false)
	private int statusPlaceID;

	@Column(name = "status", nullable = false)
	private int status;

	public StatusPlace() {
		// TODO Auto-generated constructor stub
	}

	public StatusPlace(int statusPlaceID, int status) {
		super();
		this.statusPlaceID = statusPlaceID;
		this.status = status;
	}

	public int getStatusPlaceID() {
		return statusPlaceID;
	}

	public void setStatusPlaceID(int statusPlaceID) {
		this.statusPlaceID = statusPlaceID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
