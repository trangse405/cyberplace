package com.capstone.cyberplace.dto;

public class WardData {

	private int id;
	private String wardName;
	private String wardLatitude;
	private String wardLongtitude;

	

	public WardData(int id, String wardName, String wardLatitude, String wardLongtitude) {
		super();
		this.id = id;
		this.wardName = wardName;
		this.wardLatitude = wardLatitude;
		this.wardLongtitude = wardLongtitude;
	}

	public void setWardLatitude(String wardLatitude) {
		this.wardLatitude = wardLatitude;
	}

	public void setWardLongtitude(String wardLongtitude) {
		this.wardLongtitude = wardLongtitude;
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

	public String getWardLatitude() {
		return wardLatitude;
	}

	public String getWardLongtitude() {
		return wardLongtitude;
	}
	
	

}
