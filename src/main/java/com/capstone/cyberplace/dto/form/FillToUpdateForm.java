package com.capstone.cyberplace.dto.form;

import com.capstone.cyberplace.dto.StreetData;
import com.capstone.cyberplace.dto.WardData;
import com.capstone.cyberplace.model.DistrictDB;

public class FillToUpdateForm {

	private PostPlaceForm form;
	private DistrictDB district;
	private StreetData street;
	private WardData ward;

	public FillToUpdateForm() {
		// TODO Auto-generated constructor stub
	}

	public PostPlaceForm getForm() {
		return form;
	}

	public void setForm(PostPlaceForm form) {
		this.form = form;
	}

	public DistrictDB getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDB district) {
		this.district = district;
	}

	public StreetData getStreet() {
		return street;
	}

	public void setStreet(StreetData street) {
		this.street = street;
	}

	public WardData getWard() {
		return ward;
	}

	public void setWard(WardData ward) {
		this.ward = ward;
	}

}
