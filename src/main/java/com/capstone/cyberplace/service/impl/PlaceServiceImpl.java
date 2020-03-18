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
public class PlaceServiceImpl implements PlaceService{

	@Autowired 
	private PlaceRepository placeRepository;
	
	
	@Override
	public List<Place> searchHome(String title, String district, int role, int minp, int maxp, int mina, int maxa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> getTop6() {
		
		return placeRepository.getTop6();
	}

	
	
//	
//	@Override
//	public List<Place> searchHome(String title, String district, int role, int minp, int maxp, int mina, int maxa) {
//		// TODO Auto-generated method stub
//		return placeRepository.searchHome(title, district, role, minp, maxp, mina, maxa);
//	}

}
