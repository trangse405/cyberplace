package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.DistrictDB;

public interface DistrictDBService {

	List<DistrictDB> listArea();
	void insertArea(String district);
	DistrictDB getOneDistrictByID(int districtID);
	
}
