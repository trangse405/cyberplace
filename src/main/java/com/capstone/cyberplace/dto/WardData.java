package com.capstone.cyberplace.dto;

public class WardData {

	private int id;
	private String wardName;

	public WardData() {
		// TODO Auto-generated constructor stub
	}

	public WardData(int id, String wardName) {
		super();
		this.id = id;
		this.wardName = wardName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

}
