package com.capstone.cyberplace.service;

import com.capstone.cyberplace.dto.InsertedOrderForm;

public interface OrderListService {

	
	void addOrder(InsertedOrderForm inserted , int statusOrderID);
	
	
}
