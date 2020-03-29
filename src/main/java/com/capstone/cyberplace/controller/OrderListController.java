package com.capstone.cyberplace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.InsertedOrderForm;
import com.capstone.cyberplace.dto.UpdateOrderForm;
import com.capstone.cyberplace.model.OrderList;
import com.capstone.cyberplace.service.impl.OrderListServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orderlist")
public class OrderListController {

	@Autowired
	private OrderListServiceImpl orderListServiceImpl;

	@PostMapping("/insert-order")
	public boolean insertOrder(@Valid @RequestBody InsertedOrderForm inserted) {

		try {

			orderListServiceImpl.addOrder(inserted, CommonConstant.Order_Status_ID_Pending);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@GetMapping("/get-order-place-user")
	public OrderList getOrderByPlaceIDAndUserID(@RequestParam("placeid") int placeID,
			@RequestParam("userid") int userID) {
		return orderListServiceImpl.getOrderByPlaceIDAndUserID(placeID, userID);
	}

	@PostMapping("/update-order")
	public String updateOrder(@Valid @RequestBody UpdateOrderForm updated) {

		String message = "Update Order Success";

		try {

			orderListServiceImpl.updateOrder(updated.getDateTime(), updated.getName(), updated.getEmail(),
					updated.getPhoneNumber(), updated.getMessage(), updated.getOrderID());

		} catch (Exception e) {
			message = "Some thing Wrong";
		}

		return message;
	}

	@PostMapping("/change-status-order")
	public String changeStatusOrder(@RequestParam("orderstatusid") int orderstatusid,
			@RequestParam("staffid") int staffid, @RequestParam("orderid") int orderid) {

		String message = "Change Status Order Success";

		try {

			orderListServiceImpl.changeStatusOrder(orderstatusid, staffid, orderid);

		} catch (Exception e) {
			message = "Some thing Wrong";
		}

		return message;
	}

}
