package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.repository.PlaceRepository;
import com.capstone.cyberplace.service.PlaceService;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

	@Autowired
	private PlaceRepository placeRepository;

	@Override
	public List<Place> getTop6() {

		return placeRepository.getTop6();
	}

	@Override
	public List<Place> searhPlace(String title, int districtid, int roleid, float mina, float maxa, float minp,
			float maxp) {

		return placeRepository.listSearchPlace(title, districtid, roleid, mina, maxa, minp, maxp);
	}

	@Override
	public List<Place> getAll() {

		return placeRepository.getAll();
	}

	@Override
	public Place getPlaceByPlaceID(int placeID) {

		return placeRepository.getPlaceByPlaceID(placeID);
	}

	@Override
	public void insertPlace(int userID, String title, float price, float area, int district_id, int wardID,
			int streetID, String address, int roleOfPlaceID, int statusPlaceID, int counterView, float frontispiece,
			String home_direction, int floors, int bed_rooms, int toilets, String description, String imageLarge,
			String contactName, String contactPhoneNumber, String contactAddress, String contactEmail,
			String datePost) {

		placeRepository.insertPlace(userID, title, price, area, district_id, wardID, streetID, address, roleOfPlaceID,
				statusPlaceID, counterView, frontispiece, home_direction, floors, bed_rooms, toilets, description,
				imageLarge, contactName, contactPhoneNumber, contactAddress, contactEmail, datePost);

	}

	@Override
	public Place getPlaceByMapID(int map_id) {

		return placeRepository.getPlaceByMapID(map_id);
	}

	@Override
	public void updatePlace(String title, float price, float area, int district_id, int wardID, int streetID,
			String address, int roleOfPlaceID, float frontispiece, String home_direction, int floors, int bed_rooms,
			int toilets, String description, String contactName, String contactPhoneNumber, String contactAddress,
			String contactEmail, int place_id) {
		placeRepository.updatePlace(title, price, area, district_id, wardID, streetID, address, roleOfPlaceID,
				frontispiece, home_direction, floors, bed_rooms, toilets, description, contactName, contactPhoneNumber,
				contactAddress, contactEmail, place_id);

	}

	@Override
	public Place getOneActiveByPlaceID(int id) {

		return placeRepository.getOneActiveByPlaceID(id);
	}

	@Override
	public void changeStatusPlace(int statusPlaceID, int placeID) {
		placeRepository.changeStatusPlace(statusPlaceID, placeID);

	}

}
