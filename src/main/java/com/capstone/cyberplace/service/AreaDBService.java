package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.entity.AreaDB;

public interface AreaDBService {

	List<AreaDB> listArea();
	void insertArea(String district);
	
}
