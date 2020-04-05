package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.repository.StreetDBRepository;
import com.capstone.cyberplace.service.StreetDBService;

@Service
@Transactional
public class StreetDBServiceImpl implements StreetDBService {

	@Autowired
	private StreetDBRepository streetdbRepository;

	@Override
	public List<StreetDB> getAllStreet() {

		return streetdbRepository.getAllStreet();
	}

	@Override
	public StreetDB getOneStreetByID(int streetID) {

		return streetdbRepository.getOneStreetByID(streetID);
	}

	@Override
	public List<StreetDB> getAllStreetByDistrictID(int districtID) {

		return streetdbRepository.getAllStreetByDistrictID(districtID);
	}

}
