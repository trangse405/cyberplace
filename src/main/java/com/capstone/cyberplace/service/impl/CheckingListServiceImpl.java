package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
