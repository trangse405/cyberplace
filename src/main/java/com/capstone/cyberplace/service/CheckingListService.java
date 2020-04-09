package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.CheckingList;

public interface CheckingListService {
	void insertItemToCheckingList(int place_id, String dateTime, int checkingStatusID);

	CheckingList getCheckingByPlaceID(int placeID);

	void updateItemCheckingList(int place_id, String dateTime);

	void updateStatusCheckingListItem(int checkingStatusID, int checkingID);
	
	List<CheckingList> getAllCheckingList();
}
