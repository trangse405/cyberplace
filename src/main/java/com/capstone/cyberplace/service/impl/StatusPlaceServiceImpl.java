package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.repository.StatusPlaceRepository;
import com.capstone.cyberplace.service.StatusPlaceService;

@Service
@Transactional
public class StatusPlaceServiceImpl implements StatusPlaceService {

	@Autowired
	private StatusPlaceRepository statusPlaceRepository;

	@Override
	public List<StatusPlace> getAllStatusPlace() {
		// TODO Auto-generated method stub
		return statusPlaceRepository.getAllStatusPlace();
	}

}
