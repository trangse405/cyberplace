package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.StreetDB;

public interface StreetDBService {

	List<StreetDB> getAllStreet();
	
	StreetDB getOneStreetByID(int streetID);
}
