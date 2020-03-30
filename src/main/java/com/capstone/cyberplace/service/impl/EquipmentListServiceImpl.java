package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.EquipmentList;
import com.capstone.cyberplace.repository.EquipmentListReopsitory;
import com.capstone.cyberplace.service.EquipmentListService;

@Service
@Transactional
public class EquipmentListServiceImpl implements EquipmentListService {

	@Autowired
	private EquipmentListReopsitory equipmentRepository;

	@Override
	public void insertEquipmentItem(int placeID, String equipmentName, int quantity, float price, int likeNew,
			String equipmentDescribe) {
		equipmentRepository.insertEquipmentItem(placeID, equipmentName, quantity, price, likeNew, equipmentDescribe);

	}

	@Override
	public List<EquipmentList> getListEquipByPlaceID(int placeID) {
		
		return equipmentRepository.getListEquipByPlaceID(placeID);
	}

}
