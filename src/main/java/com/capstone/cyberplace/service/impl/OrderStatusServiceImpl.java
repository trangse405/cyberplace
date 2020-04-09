package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.OrderStatus;
import com.capstone.cyberplace.repository.OrderStatusRepository;
import com.capstone.cyberplace.service.OrderStatusService;

@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusRepository orderStatusRepository;

	@Override
	public List<OrderStatus> getAllOrderStatus() {
		return orderStatusRepository.getAllOrderStatus();
	}

}
