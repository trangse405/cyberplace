package com.capstone.cyberplace.service;

import com.capstone.cyberplace.model.Map;

public interface MapService {

	Map getOneByMapID(int mapID);

	void insertMap(float longtitude, float latitude, int place_id);

	Map getMapIDByPlaceID(int place_id);
}
