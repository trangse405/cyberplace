package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.CostOfPlace;

public interface CostOfPlaceService {
	void insertItemCostOfPlace(int place_id, String costName, float costPrice);

	List<CostOfPlace> getListCostByPlaceID(int place_id);

	void deleteListCostByPlaceID(int placeID);
}
