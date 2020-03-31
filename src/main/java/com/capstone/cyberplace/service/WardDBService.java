package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.WardDB;

public interface WardDBService {

	List<WardDB> listAllWard();

	WardDB getOneWardByID(int wardID);

	List<WardDB> getAllWardByDistrictID(int districtID);
}
