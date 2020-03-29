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
	public Place getOneByID(int id) {
		return placeRepository.getOneByID(id);
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
	public Place checkPlace(int placeID) {

		return placeRepository.getPlaceByPlaceIDAndStatusID(placeID);
	}

}
