package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.capstone.cyberplace.dto.form.ChangeStatusOrderForm;
import com.capstone.cyberplace.dto.form.InsertedOrderForm;
import com.capstone.cyberplace.dto.form.OrderForm;
import com.capstone.cyberplace.dto.form.UpdateOrderForm;
import com.capstone.cyberplace.model.OrderList;
import com.capstone.cyberplace.model.OrderStatus;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.service.impl.OrderListServiceImpl;
import com.capstone.cyberplace.service.impl.OrderStatusServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orderlist")
public class OrderListController {

	@Autowired
	private OrderListServiceImpl orderListServiceImpl;

	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;

	@Autowired
	private OrderStatusServiceImpl orderStatusServiceImpl;
	
	/*
	 * api to insert an order by InsertedOrderForm;
	 */
	@PostMapping("/insert-order")
	public boolean insertOrder(@Valid @RequestBody InsertedOrderForm inserted) {

		Place p = placeServiceImpl.getPlaceByPlaceID(inserted.getPlaceID());

		if (p.getStatusPlaceID() != 1) {
			return false;
		}

		try {

			orderListServiceImpl.addOrder(inserted, CommonConstant.Order_Status_ID_Pending);

		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	/*
	 * api to get and order by place id and user id
	 */
	@GetMapping("/get-order-place-user")
	public OrderList getOrderByPlaceIDAndUserID(@RequestParam("placeid") int placeID,
			@RequestParam("userid") int userID) {
		return orderListServiceImpl.getOrderByPlaceIDAndUserID(placeID, userID);
	}
	
	
	/*
	 * api update order by UpdateOrderForm
	 */
	@PostMapping("/update-order")
	public boolean updateOrder(@Valid @RequestBody UpdateOrderForm updated) {

		try {

			orderListServiceImpl.updateOrder(updated.getDateTime(), updated.getName(), updated.getEmail(),
					updated.getPhoneNumber(), updated.getMessage(), updated.getOrderID());

		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	
	/*
	 * api to change status order
	 */
	@PostMapping("/change-status-order")
	public boolean changeStatusOrder(@Valid @RequestBody ChangeStatusOrderForm form) {

		try {

			orderListServiceImpl.changeStatusOrder(form.getStatusOrderID(), form.getOrderID());
			placeServiceImpl.changeStatusPlace(form.getStatusPlaceID(), form.getPlaceID());

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	
	/*
	 * api to get order by user id
	 */
	@GetMapping("/get-order-by-userid")
	public List<OrderForm> getListOrderByUserID(@RequestParam("userID") int userID) {

		List<OrderForm> listF = new ArrayList<>();
		List<OrderList> listO = new ArrayList<>();
		listO = orderListServiceImpl.getOrderListUserID(userID);
		List<StatusPlace> listStatusPlace = statusPlaceServiceImpl.getAllStatusPlace();
		List<OrderStatus> listOrderStatus = orderStatusServiceImpl.getAllOrderStatus();
		List<Place> listPlace = placeServiceImpl.getAllPlace();
		if (listO != null) {
			for (OrderList o : listO) {
				OrderForm f = new OrderForm();
				f.setDateTime(String.valueOf(o.getDateTime()));
				f.setEmail(o.getEmail());
				f.setMessage(o.getMessage());
				f.setName(o.getName());
				f.setOrdererID(o.getOrdererID());
				f.setPhoneNumber(o.getPhone_number());
				f.setOrderStatusID(o.getOrderStatusID());
				f.setPlaceID(o.getPlaceID());
				f.setOrderID(o.getOrderID());
				for (Place p : listPlace) {
					if (o.getPlaceID() == p.getPlaceID()) {
						f.setTitle(p.getTitle());
						f.setPlaceStatusID(p.getStatusPlaceID());
						for (StatusPlace sp : listStatusPlace) {
							if (p.getStatusPlaceID() == sp.getStatusPlaceID()) {
								f.setPlaceStatus(sp.getStatus());
							}
						}
					}
				}

				for (OrderStatus os : listOrderStatus) {
					if (o.getOrderStatusID() == os.getOrderStatusID()) {
						f.setOrderStatus(os.getOrderStatusName());
					}
				}

				listF.add(f);
			}
		}
		return listF;
	}

	// --------------------------------------------------------------
// pending
	@PostMapping("/change-status-order-staff")
	public String changeStatusOrderWithStaff(@RequestParam("orderstatusid") int orderstatusid,
			@RequestParam("staffid") int staffid, @RequestParam("orderid") int orderid) {

		String message = "Change Status Order Success";

		try {

			orderListServiceImpl.changeStatusOrderWithStaff(orderstatusid, staffid, orderid);

		} catch (Exception e) {
			message = "Some thing Wrong";
		}

		return message;
	}

}
