package com.capstone.cyberplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.model.Payment;
import com.capstone.cyberplace.service.impl.PaymentServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
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
			placeServiceImpl.changeStatusPlace(CommonConstant.Place_Status_ID_Deposited, paymentInfo.getPlaceID());
		}

		return true;
	}

}
