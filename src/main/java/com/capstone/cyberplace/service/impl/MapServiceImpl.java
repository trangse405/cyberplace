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

	@Override
	public void insertMap(float longtitude, float latitude, int place_id) {
		mapRepository.insertMap(latitude, longtitude, place_id);

	}

	@Override
	public Map getMapIDByPlaceID(int place_id) {

		return mapRepository.getMapIDByPlaceID(place_id);
	}

	@Override
	public void updateMap(float latitude, float longtitude, int place_id) {
		mapRepository.updateMap(latitude, longtitude, place_id);

	}

}
