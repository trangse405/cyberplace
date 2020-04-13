package com.capstone.cyberplace.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.cyberplace.dto.form.AdminManageOrderForm;
import com.capstone.cyberplace.model.OrderList;
import com.capstone.cyberplace.model.OrderStatus;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.model.UserDetail;
import com.capstone.cyberplace.service.impl.OrderListServiceImpl;
import com.capstone.cyberplace.service.impl.OrderStatusServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/manageorder")
public class ManageOrderController {

	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private OrderListServiceImpl orderListServiceImpl;

	@Autowired
	private OrderStatusServiceImpl orderStatusServiceImpl;

	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;

	@GetMapping("/get-all-order")
	public List<AdminManageOrderForm> getAllOrder() {
		List<AdminManageOrderForm> list = new ArrayList<>();

		List<OrderStatus> listOS = orderStatusServiceImpl.getAllOrderStatus();
		List<OrderList> listO = new ArrayList<>();
		List<StatusPlace> listSP = statusPlaceServiceImpl.getAllStatusPlace();
		listO = orderListServiceImpl.getAllOrder();
		if (listO != null) {
			for (OrderList o : listO) {
				AdminManageOrderForm a = new AdminManageOrderForm();
				a.setContactName(o.getName());
				a.setEmail(o.getEmail());
				a.setOrderStatusID(o.getOrderStatusID());
				a.setPhoneNumber(o.getPhone_number());
				a.setMessage(o.getMessage());
				a.setDateTime(String.valueOf(o.getDateTime()));
				a.setOrderID(o.getOrderID());
				Place p = placeServiceImpl.getPlaceByPlaceID(o.getPlaceID());
				a.setAddress(p.getAddress());
				a.setPlaceID(o.getPlaceID());
				a.setStatusPlaceID(p.getStatusPlaceID());

				UserDetail ud = userDetailServiceImpl.getDetailByUserID(o.getOrdererID());
				a.setName(ud.getName());
				for (OrderStatus os : listOS) {
					if (o.getOrderStatusID() == os.getOrderStatusID()) {
						a.setStatus(os.getOrderStatusName());
					}
				}
				for (StatusPlace sp : listSP) {
					if (p.getStatusPlaceID() == sp.getStatusPlaceID()) {
						a.setStatusPlace(sp.getStatus());
					}
				}

				list.add(a);
			}
		}

		return list;
	}

	@GetMapping("/count-order-pending")
	public int countOrderPendingByPlaceID(@RequestParam("placeID") int placeID) {
		List<OrderList> list = new ArrayList<>();
		list = orderListServiceImpl.getAllOrderPendingByPlaceID(placeID);

		return list.size();
	}
}
