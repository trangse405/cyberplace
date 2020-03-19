package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.Place;

public interface PlaceService {

	
	List<Place> searchHome(String title, String district, int role, int minp, int maxp, int mina, int maxa);
	
	List<Place> getTop6();

	
}
