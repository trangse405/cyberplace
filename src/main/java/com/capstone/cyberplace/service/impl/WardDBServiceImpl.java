package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.WardDB;
import com.capstone.cyberplace.repository.WardDBRepository;
import com.capstone.cyberplace.service.WardDBService;

@Service
@Transactional
public class WardDBServiceImpl implements WardDBService {

	@Autowired
	private WardDBRepository wardDBRepository;

	@Override
	public List<WardDB> listAllWard() {

		return wardDBRepository.getAllWard();
	}

	@Override
	public WardDB getOneWardByID(int wardID) {

		return wardDBRepository.getOneWardByID(wardID);
	}

	@Override
	public List<WardDB> getAllWardByDistrictID(int districtID) {

		return wardDBRepository.getAllWardByDistrictID(districtID);
	}

}
