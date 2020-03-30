package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.Place;

public interface PlaceService {

	List<Place> searhPlace(String title, int districtid, int roleid, float mina, float maxa, float minp, float maxp);

	List<Place> getTop6();

	Place getOneByID(int id);

	List<Place> getAll();

	Place checkPlace(int placeID);

	void insertPlace(int userID, String title, float price, float area, int district_id, int wardID, int streetID,
			String address, int mapID, int roleOfPlaceID, int statusPlaceID, int counterView, float frontispiece,
			String home_direction, int floors, int bed_rooms, int toilets, String description, String imageLarge,
			String contactName, String contactPhoneNumber, String contactAddress, String contactEmail);

	
	Place getPlaceByMapID( int map_id);
}
