package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WardDB")
public class WardDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "district_id")
	private int district_id;

	@Column(name = "ward_name")
	private String ward_name;

	@Column(name = "ward_type")
	private String wardType;

	@Column(name = "ward_latitude")
	private String wardLatitude;

	@Column(name = "ward_longitude")
	private String wardLongitude;

	public WardDB() {
		// TODO Auto-generated constructor stub
	}

	public WardDB(int id, int district_id, String ward_name, String wardType, String wardLatitude,
			String wardLongitude) {
		super();
		this.id = id;
		this.district_id = district_id;
		this.ward_name = ward_name;
		this.wardType = wardType;
		this.wardLatitude = wardLatitude;
		this.wardLongitude = wardLongitude;
	}

	public String getWardType() {
		return wardType;
	}

	public void setWardType(String wardType) {
		this.wardType = wardType;
	}

	public String getWardLatitude() {
		return wardLatitude;
	}

	public void setWardLatitude(String wardLatitude) {
		this.wardLatitude = wardLatitude;
	}

	public String getWardLongitude() {
		return wardLongitude;
	}

	public void setWardLongitude(String wardLongitude) {
		this.wardLongitude = wardLongitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getWard_name() {
		return ward_name;
	}

	public void setWard_name(String ward_name) {
		this.ward_name = ward_name;
	}

}
