package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.dto.form.InsertedOrderForm;
import com.capstone.cyberplace.model.OrderList;

public interface OrderListService {

	void addOrder(InsertedOrderForm inserted, int statusOrderID);

	void changeStatusOrderWithStaff(int orderStatusID, int stafID, int orderID);

	void updateOrder(String dateTime, String name, String email, String phoneNumber, String message, int orderID);

	OrderList getOrderByPlaceIDAndUserID(int placeID, int userID);

	void changeStatusOrder(int orderStatusID, int orderID);

	List<OrderList> getOrderListUserID(int ordererID);

}
