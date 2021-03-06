package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.Payment;
import com.capstone.cyberplace.repository.PaymentRepository;
import com.capstone.cyberplace.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void insertPaymentInfo(int userID, int placeID, String createTime, String status, String payerID,
			float money, String description, String orderID) {
		paymentRepository.insertPaymentInfo(userID, placeID, createTime, status, payerID, money, description, orderID);

	}

	@Override
	public List<Payment> getAllPayment() {

		return paymentRepository.getAllPayment();
	}

	@Override
	public List<Payment> getPaymentByUserID(int userID) {
		// TODO Auto-generated method stub
		return paymentRepository.getPaymentByUserID(userID);
	}

}
