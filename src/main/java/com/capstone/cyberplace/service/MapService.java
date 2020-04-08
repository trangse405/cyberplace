package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.Map;

public interface MapService {

	Map getOneByMapID(int mapID);

	void insertMap(String longtitude, String latitude, int place_id);

	Map getMapIDByPlaceID(int place_id);

	void updateMap(String latitude, String longtitude, int place_id);

	List<Map> getAllMap();
}
