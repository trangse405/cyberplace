package com.capstone.cyberplace.service;

import com.capstone.cyberplace.model.Map;

public interface MapService {

	Map getOneByMapID(int mapID);

	void insertMap(float longtitude, float latitude);
	
	Map getMapIDByLongtitudeAndLatitude( float latitude,float longtitude);
}
