package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DistrictDB")
public class DistrictDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "district_name", nullable = false)
	private String district;

	@Column(name = "district_latitude")
	private String districtLatitude;

	@Column(name = "district_longitude")
	private String districtLongitude;

	@Column(name = "district_type")
	private String districtType;

	public DistrictDB() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public DistrictDB(int id, String district, String districtLatitude, String districtLongitude, String districtType) {
		super();
		this.id = id;
		this.district = district;
		this.districtLatitude = districtLatitude;
		this.districtLongitude = districtLongitude;
		this.districtType = districtType;
	}

	public String getDistrictLatitude() {
		return districtLatitude;
	}

	public void setDistrictLatitude(String districtLatitude) {
		this.districtLatitude = districtLatitude;
	}

	public String getDistrictLongitude() {
		return districtLongitude;
	}

	public void setDistrictLongitude(String districtLongitude) {
		this.districtLongitude = districtLongitude;
	}

	public String getDistrictType() {
		return districtType;
	}

	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}

}
