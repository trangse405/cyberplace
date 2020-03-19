package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.repository.StreetDBRepository;
import com.capstone.cyberplace.service.StreetDBService;

public class StreetDBServiceImpl implements StreetDBService {

	@Autowired
	private StreetDBRepository streetdbRepository;

	@Override
	public List<StreetDB> getAllStreet() {

		return streetdbRepository.getAllStreet();
	}

}
