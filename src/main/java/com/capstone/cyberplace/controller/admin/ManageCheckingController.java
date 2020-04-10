package com.capstone.cyberplace.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.AdminManageCheckingForm;
import com.capstone.cyberplace.model.CheckingList;
import com.capstone.cyberplace.model.CheckingStatus;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.model.UserDetail;
import com.capstone.cyberplace.service.impl.CheckingListServiceImpl;
import com.capstone.cyberplace.service.impl.CheckingStatusServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/managechecking")
public class ManageCheckingController {

	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private CheckingListServiceImpl checkingListServiceImpl;
	@Autowired
	private CheckingStatusServiceImpl checkingStatusServiceImpl;

	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;

	@GetMapping("/get-all-checking")
	public List<AdminManageCheckingForm> getAllChecking() {
		List<AdminManageCheckingForm> list = new ArrayList<>();

		List<CheckingStatus> listCS = checkingStatusServiceImpl.getAllCheckingStatus();
		List<CheckingList> listC = new ArrayList<>();
		List<StatusPlace> listSP = statusPlaceServiceImpl.getAllStatusPlace();
		listC = checkingListServiceImpl.getAllCheckingList();
		if (listC != null) {
			for (CheckingList c : listC) {
				AdminManageCheckingForm a = new AdminManageCheckingForm();
				a.setCheckingID(c.getCheckingID());
				a.setDateTime(String.valueOf(c.getDateTime()));
				Place p = placeServiceImpl.getPlaceByPlaceID(c.getPlaceID());
				a.setPlaceID(c.getPlaceID());
				a.setContactName(p.getContactName());
				a.setPhoneNumber(p.getContactPhoneNumber());
				a.setTitle(p.getTitle());
				UserDetail ud = userDetailServiceImpl.getDetailByUserID(p.getOwnerID());
				a.setUserName(ud.getName());
				a.setStatusPlaceID(p.getStatusPlaceID());
				for (CheckingStatus cs : listCS) {
					if (c.getCheckingStatusID() == cs.getCheckingStatusID()) {
						a.setStatus(cs.getCheckingStatusName());
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
}
