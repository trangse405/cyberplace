package com.capstone.cyberplace.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.ManagePostForm;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/manageplace")
public class ManagePlaceController {
	
	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;
	
	@GetMapping("/get-all-place")
	public List<ManagePostForm> getAllPlace() {
		List<ManagePostForm> list = new ArrayList<>();

		
		List<Place> listP = new ArrayList<>();
		List<StatusPlace> listSP = statusPlaceServiceImpl.getAllStatusPlace();
		listP = placeServiceImpl.getAllPlace();
		if (listP != null) {
			for (Place p : listP) {
				ManagePostForm a = new ManagePostForm();
				a.setId(p.getPlaceID());
				a.setAddress(p.getAddress());
				a.setDatePost(p.getDatePost());
				a.setImageLarge(p.getImage_large());
				a.setPrice(p.getPrice());
				a.setStatusID(p.getStatusPlaceID());
				a.setTitle(p.getTitle());
				for (StatusPlace sp : listSP) {
					if (p.getStatusPlaceID() == sp.getStatusPlaceID()) {
						a.setStatus(sp.getStatus());
					}
				}

				list.add(a);
			}
		}

		return list;
	}

}
