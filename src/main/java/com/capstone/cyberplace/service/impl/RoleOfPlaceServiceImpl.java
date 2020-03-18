package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.repository.RoleOfPlaceRepository;
import com.capstone.cyberplace.service.RoleOfPlaceService;

@Service
@Transactional
public class RoleOfPlaceServiceImpl implements RoleOfPlaceService{

	@Autowired
	private RoleOfPlaceRepository roleOfPlaceRepository;
	
	@Override
	public List<RoleOfPlace> getAllRole() {
		
		return roleOfPlaceRepository.getall();
	}

}
