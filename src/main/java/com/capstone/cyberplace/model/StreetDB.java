package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DistrictDB")
public class StreetDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "ward_id", nullable = false)
	private int wardID;

	@Column(name = "street_name", nullable = false)
	private String streetName;

	public StreetDB() {
		// TODO Auto-generated constructor stub
	}

	public StreetDB(int id, int wardID, String streetName) {
		super();
		this.id = id;
		this.wardID = wardID;
		this.streetName = streetName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWardID() {
		return wardID;
	}

	public void setWardID(int wardID) {
		this.wardID = wardID;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

}
