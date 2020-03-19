package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.Map;
import com.capstone.cyberplace.repository.MapRepository;
import com.capstone.cyberplace.service.MapService;

@Service
@Transactional
public class MapServiceImpl implements MapService {

	@Autowired
	private MapRepository mapRepository;

	@Override
	public Map getOneByMapID(int mapID) {
	
		return mapRepository.getOneByMapID(mapID);
	}

}
