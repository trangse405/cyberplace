package com.capstone.cyberplace.dto;

public class StreetData {

	private int id;
	private String streetName;

	public StreetData() {
		// TODO Auto-generated constructor stub
	}

	public StreetData(int id, String streetName) {
		super();
		this.id = id;
		this.streetName = streetName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

}
