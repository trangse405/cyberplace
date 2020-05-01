package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.model.Payment;
import com.capstone.cyberplace.service.impl.PaymentServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@PostMapping("/insert-payment")
	public boolean insertPaymentInfo(@RequestBody Payment paymentInfo) {

		boolean checkPayment = false;
		try {
			paymentServiceImpl.insertPaymentInfo(paymentInfo.getUserID(), paymentInfo.getPlaceID(),
					paymentInfo.getCreateTime(), paymentInfo.getStatus(), paymentInfo.getPayerID(),
					paymentInfo.getMoney(), paymentInfo.getDescription(), paymentInfo.getOrderID());
			checkPayment = true;
		} catch (Exception e) {
			return false;
		}
		if (checkPayment == true) {
			// placeServiceImpl.changeStatusPlace(CommonConstant.Place_Status_ID_Deposited,
			// paymentInfo.getPlaceID());
		}

		return true;
	}

	@GetMapping("/getallpayment")
	public List<Payment> getAllPayment() {

		List<Payment> list = new ArrayList<>();

		try {
			list = paymentServiceImpl.getAllPayment();
		} catch (Exception e) {
			System.err.println("get all payment err");
		}

		return list;
	}

	@GetMapping("/getpaymentbyuserid")
	public List<Payment> getPaymentByUserID(@RequestParam("userID") int userID) {

		List<Payment> list = new ArrayList<>();

		try {
			list = paymentServiceImpl.getPaymentByUserID(userID);
		} catch (Exception e) {
			System.err.println("get  payment by userid  err");
		}

		return list;
	}

}
