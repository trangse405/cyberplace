package com.capstone.cyberplace.service;

import com.capstone.cyberplace.model.CheckingList;

public interface CheckingListService {
	void insertItemToCheckingList(int place_id, String dateTime, int checkingStatusID);

	CheckingList getCheckingByPlaceID(int placeID);

	void updateItemToCheckingList(int place_id, String dateTime);
}
