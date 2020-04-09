package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.CheckingList;
import com.capstone.cyberplace.repository.CheckingListRepository;
import com.capstone.cyberplace.service.CheckingListService;

@Service
@Transactional
public class CheckingListServiceImpl implements CheckingListService {

	@Autowired
	private CheckingListRepository checkingListRepository;

	@Override
	public void insertItemToCheckingList(int place_id, String dateTime, int checkingStatusID) {
		checkingListRepository.insertItemToCheckingList(place_id, dateTime, checkingStatusID);

	}

	@Override
	public CheckingList getCheckingByPlaceID(int placeID) {

		return checkingListRepository.getCheckingByPlaceID(placeID);
	}

	@Override
	public void updateItemCheckingList(int place_id, String dateTime) {
		checkingListRepository.updateItemCheckingList(place_id, dateTime);

	}

	@Override
	public void updateStatusCheckingListItem(int checkingStatusID, int checkingID) {
		checkingListRepository.updateStatusCheckingListItem(checkingStatusID, checkingID);

	}

	@Override
	public List<CheckingList> getAllCheckingList() {

		return checkingListRepository.getAllCheckingList();
	}

}
