package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.Place;

public interface PlaceService {

	List<Place> searhPlace(String title, int districtid, int roleid, float mina, float maxa, float minp, float maxp);

	List<Place> getTop6();

	Place getOneByID(int id);

	List<Place> getAll();

}
