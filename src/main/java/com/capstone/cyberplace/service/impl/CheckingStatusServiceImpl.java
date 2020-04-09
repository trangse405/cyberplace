package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.CheckingStatus;
import com.capstone.cyberplace.repository.CheckingStatusRepository;
import com.capstone.cyberplace.service.CheckingStatusService;

@Service
@Transactional
public class CheckingStatusServiceImpl implements CheckingStatusService {

	@Autowired
	private CheckingStatusRepository checkingStatusRepository;

	@Override
	public List<CheckingStatus> getAllCheckingStatus() {

		return checkingStatusRepository.getAllCheckingStatus();
	}

}
