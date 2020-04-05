package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.EquipmentList;

public interface EquipmentListService {

	void insertEquipmentItem(int placeID, String equipmentName, int quantity, float price, int likeNew,
			String equipmentDescribe);

	List<EquipmentList> getListEquipByPlaceID(int placeID);

	void deleteListEquipByPlaceID(int placeID);
}
