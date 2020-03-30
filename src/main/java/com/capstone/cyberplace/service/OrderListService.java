package com.capstone.cyberplace.service;

import com.capstone.cyberplace.dto.form.InsertedOrderForm;
import com.capstone.cyberplace.model.OrderList;

public interface OrderListService {

	void addOrder(InsertedOrderForm inserted, int statusOrderID);

	void changeStatusOrder(int orderStatusID, int stafID, int orderID);

	void updateOrder(String dateTime, String name, String email, String phoneNumber, String message, int orderID);

	OrderList getOrderByPlaceIDAndUserID(int placeID, int userID);

}
