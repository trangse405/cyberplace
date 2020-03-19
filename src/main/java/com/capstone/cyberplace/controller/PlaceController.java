package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.PlaceQuickView;
import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;
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
	@Autowired
	private DistrictDBServiceImpl districtDBServiceImpl;

	@GetMapping("/places/top6")
	public List<PlaceQuickView> getTop6() {

		List<Place> listP = placeServiceImpl.getTop6();
		List<RoleOfPlace> listR = roleOfPlaceServiceImpl.getAllRole();
		List<DistrictDB> listD = districtDBServiceImpl.listArea();

		List<PlaceQuickView> list = new ArrayList<>();
		for (Place p : listP) {
			for (RoleOfPlace rop : listR) {
				if (rop.getRoleOfPlaceID() == p.getRoleOfPlaceID()) {
					PlaceQuickView item = new PlaceQuickView();
					item.setArea(p.getArea());
					item.setImageLarge(p.getImage_large());
					item.setPlaceID(p.getPlaceID());
					item.setPrice(p.getPrice());
					item.setBedRooms(p.getBedRooms());
					item.setRoleOfPlaceName(rop.getRoleName());
					item.setTitle(p.getTitle());
					item.setToilets(p.getToilets());

					for (DistrictDB d : listD) {
						if (p.getDistrict_id() == d.getId()) {
							item.setDistrict(d.getDistrict());
						}
					}

					list.add(item);
				}
			}
		}

		return list;
	}

	@GetMapping("/places/getonebyid")
	public Place getOneById(@RequestParam("id") int id) {

		return placeServiceImpl.getOneByID(id);
	}

}
