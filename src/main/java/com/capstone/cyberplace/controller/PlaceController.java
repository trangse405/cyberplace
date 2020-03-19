package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.Place_RoleName;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.RoleOfPlaceServiceImpl;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cp")
public class PlaceController {
//	private static EntityManagerFactory entityManagerFactory =
//	          Persistence.createEntityManagerFactory("example-unit");

	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@Autowired
	private RoleOfPlaceServiceImpl roleOfPlaceServiceImpl;

	@GetMapping("/places/top6")
	public List<Place_RoleName> getAllStatistic() {

		List<Place> listP = placeServiceImpl.getTop6();
		List<RoleOfPlace> listR = roleOfPlaceServiceImpl.getAllRole();

		List<Place_RoleName> list = new ArrayList<>();
		for(Place p : listP ) {
			for(RoleOfPlace rop : listR) {
				if(rop.getRoleOfPlaceID() == p.getRoleOfPlaceID()) {
					Place_RoleName item = new Place_RoleName();
					item.setArea(p.getArea());
					item.setDescription(p.getDescription());
					item.setImage_large(p.getImage_large());
					item.setPlace_id(p.getPlaceID());
					item.setPrice(p.getPrice());
					item.setRooms(p.getFloors());
					item.setRole_of_place_name(rop.getRoleName());
					item.setTitle(p.getTitle());
					list.add(item);
				}
			}
		}
		
		return list;
	}

}
