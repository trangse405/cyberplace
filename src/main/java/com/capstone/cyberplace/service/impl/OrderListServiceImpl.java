package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.dto.form.InsertedOrderForm;
import com.capstone.cyberplace.model.OrderList;
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
				inserted.getDateTime(), inserted.getName(), inserted.getEmail(), inserted.getPhoneNumber(),
				inserted.getMessage());
	}

	@Override
	public void changeStatusOrderWithStaff(int orderStatusID, int staffID, int orderID) {
		orderListRepository.changeStatusOrderWithStaff(orderStatusID, staffID, orderID);

	}

	@Override
	public void updateOrder(String dateTime, String name, String email, String phoneNumber, String message,
			int orderID) {

		orderListRepository.updateOrder(dateTime, name, email, phoneNumber, message, orderID);
	}

	@Override
	public OrderList getOrderByPlaceIDAndUserID(int placeID, int userID) {

		return orderListRepository.getOrderByPlaceIDAndUserID(placeID, userID);
	}

	@Override
	public void changeStatusOrder(int orderStatusID, int orderID) {
		orderListRepository.changeStatusOrder(orderStatusID, orderID);

	}

	@Override
	public List<OrderList> getOrderListUserID(int ordererID) {

		return orderListRepository.getOrderListUserID(ordererID);
	}

	@Override
	public List<OrderList> getAllOrder() {

		return orderListRepository.getAllOrder();
	}

}
