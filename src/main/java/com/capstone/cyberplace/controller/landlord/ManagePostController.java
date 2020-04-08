package com.capstone.cyberplace.controller.landlord;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.ManagePostForm;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/managepost")
public class ManagePostController {

	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;

	@GetMapping("/getallpost")
	public List<ManagePostForm> getAllPost(@RequestParam("userid") int userID) {
		List<ManagePostForm> list = new ArrayList<>();

		List<Place> listP = placeServiceImpl.getListForManagePost(userID);

		List<StatusPlace> listS = statusPlaceServiceImpl.getAllStatusPlace();

		for (Place p : listP) {
			for (StatusPlace s : listS) {
				if (p.getStatusPlaceID() == s.getStatusPlaceID()) {
					ManagePostForm m = new ManagePostForm();
					m.setImageLarge(p.getImage_large());
					m.setId(p.getPlaceID());
					m.setAddress(p.getAddress());
					m.setDatePost(p.getDatePost());
					m.setPrice(p.getPrice());
					m.setTitle(p.getTitle());
					m.setStatus(s.getStatus());
					m.setStatusID(p.getStatusPlaceID());
					list.add(m);
				}
			}

		}

		return list;
	}

	@PostMapping("/change-status-place")
	public boolean changeStatusPlace(@RequestParam("placeID") int placeID,
			@RequestParam("statusPlaceID") int statusPlaceID) {

		try {
			placeServiceImpl.changeStatusPlace(statusPlaceID, placeID);
		} catch (Exception e) {
			System.err.println("change status false");
			return false;
		}

		return true;
	}

}
