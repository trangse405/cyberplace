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

import com.capstone.cyberplace.dto.form.ChangeStatusCheckingForm;
import com.capstone.cyberplace.model.CheckingList;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.service.impl.CheckingListServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/checkinglist")
public class CheckingListController {

	@Autowired
	private CheckingListServiceImpl checkingListServiceImpl;

	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@PostMapping("/change-status-checking")
	public boolean changeStatusChecking(@Valid @RequestBody ChangeStatusCheckingForm form) {

		try {

			checkingListServiceImpl.updateStatusCheckingListItem(form.getStatusCheckingID(), form.getCheckingID());
			placeServiceImpl.changeStatusPlace(form.getStatusPlaceID(), form.getPlaceID());

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@GetMapping("/get-checking-list")
	public List<CheckingList> getAllCheckingListbyUserID(@RequestParam("userID") int userID) {
		List<Place> listP = new ArrayList<Place>();

		listP = placeServiceImpl.getListForManagePost(userID);
		List<CheckingList> listC = new ArrayList<CheckingList>();
		if (listP != null) {
			for (Place p : listP) {
				CheckingList c = new CheckingList();
				c = checkingListServiceImpl.getCheckingByPlaceID(p.getPlaceID());
				if (c != null) {
					listC.add(c);
				}

			}
		}

		return listC;
	}

	@GetMapping("/get-all-checking-list")
	public List<CheckingList> getAllCheckingList() {

		List<CheckingList> listC = checkingListServiceImpl.getAllCheckingList();

		return listC;
	}
}
