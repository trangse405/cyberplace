package com.capstone.cyberplace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.InsertedOrderForm;
import com.capstone.cyberplace.service.impl.OrderListServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orderlist")
public class OrderListController {

	@Autowired
	private OrderListServiceImpl orderListServiceImpl;

	@PostMapping("/insert-order")
	public String insertOrder(@Valid @RequestBody InsertedOrderForm inserted) {

		String message = "Insert Order Success";

		try {
			
			orderListServiceImpl.addOrder(inserted, CommonConstant.Order_Status_ID_Pending);
			
		} catch (Exception e) {
			message = "Some thing Wrong";
		}
		
		return message;
	}

}
