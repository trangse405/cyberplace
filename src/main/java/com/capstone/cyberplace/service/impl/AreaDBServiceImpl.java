package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.entity.AreaDB;
import com.capstone.cyberplace.repository.AreaDBRepository;
import com.capstone.cyberplace.service.AreaDBService;


@Service
@Transactional
public class AreaDBServiceImpl implements AreaDBService{

	
	@Autowired
	private AreaDBRepository areaDBRepository;
	
	
	@Override
	public List<AreaDB> listArea() {
		
		return areaDBRepository.getall();
	}

	@Override
	public void insertArea(String district) {
		areaDBRepository.insertArea(district);
		
	}

}
