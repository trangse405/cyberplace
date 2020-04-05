package com.capstone.cyberplace.service;

public interface PaymentService {

	void insertPaymentInfo(int userID, int placeID, String createTime, String status, String payerID, float money,
			String description , String orderID);

}
