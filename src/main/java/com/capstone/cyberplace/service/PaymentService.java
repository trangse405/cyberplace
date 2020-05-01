package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.Payment;

public interface PaymentService {

	void insertPaymentInfo(int userID, int placeID, String createTime, String status, String payerID, float money,
			String description , String orderID);
	
	List<Payment> getAllPayment();
	
	List<Payment> getPaymentByUserID( int userID);

}
