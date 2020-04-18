package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.CostOfPlace;
import com.capstone.cyberplace.repository.CostOfPlaceRepository;
import com.capstone.cyberplace.service.CostOfPlaceService;

@Service
@Transactional
public class CostOfPlaceServiceImpl implements CostOfPlaceService {

	@Autowired
	private CostOfPlaceRepository costOfPlaceRepository;

	@Override
	public void insertItemCostOfPlace(int place_id, String costName, float costPrice, int unitID) {
		costOfPlaceRepository.insertItemCostOfPlace(place_id, costName, costPrice,  unitID);

	}

	@Override
	public List<CostOfPlace> getListCostByPlaceID(int place_id) {

		return costOfPlaceRepository.getListCostByPlaceID(place_id);
	}

	@Override
	public void deleteListCostByPlaceID(int placeID) {
		costOfPlaceRepository.deleteListCostByPlaceID(placeID);

	}

}
