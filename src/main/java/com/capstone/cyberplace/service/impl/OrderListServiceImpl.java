package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.dto.InsertedOrderForm;
import com.capstone.cyberplace.repository.OrderListRepository;
import com.capstone.cyberplace.service.OrderListService;

@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {

	@Autowired
	private OrderListRepository orderListRepository;

	@Override
	public void addOrder(InsertedOrderForm inserted, int statusOrderID) {
		orderListRepository.addOrder(inserted.getOrdererID(), inserted.getPlaceID(), statusOrderID,
				inserted.getDateTime(), inserted.getName(), inserted.getEmail(), inserted.getPhoneNumber());
	}

}
