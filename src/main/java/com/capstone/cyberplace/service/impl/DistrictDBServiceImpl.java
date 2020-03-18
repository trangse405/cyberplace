package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.repository.DistrictDBRepository;
import com.capstone.cyberplace.service.DistrictDBService;


@Service
@Transactional
public class DistrictDBServiceImpl implements DistrictDBService{

	
	@Autowired
	private DistrictDBRepository areaDBRepository;
	
	
	@Override
	public List<DistrictDB> listArea() {
		
		return areaDBRepository.getall();
	}

	@Override
	public void insertArea(String district) {
		areaDBRepository.insertArea(district);
		
	}

}
