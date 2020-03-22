package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.PlaceDetail;
import com.capstone.cyberplace.dto.PlaceQuickView;
import com.capstone.cyberplace.dto.SearchCondition;
import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.model.Map;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.model.WardDB;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;
import com.capstone.cyberplace.service.impl.MapServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.RoleOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StreetDBServiceImpl;
import com.capstone.cyberplace.service.impl.WardDBServiceImpl;

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
	@Autowired
	private WardDBServiceImpl wardDBServiceImpl;
	@Autowired
	private StreetDBServiceImpl streetDBServiceImpl;
	@Autowired
	private MapServiceImpl mapServiceImpl;

	@GetMapping("/places/top6")
	public List<PlaceQuickView> getTop6() {

		List<Place> listP = placeServiceImpl.getTop6();

		return getPlaceQuickView(listP);
	}

	@GetMapping("/places/{id}")
	public PlaceDetail getOneById(@PathVariable int id) {

		Place p = placeServiceImpl.getOneByID(id);
		DistrictDB d = districtDBServiceImpl.getOneDistrictByID(p.getDistrict_id());
		WardDB w = wardDBServiceImpl.getOneWardByID(p.getWard_id());
		StreetDB s = streetDBServiceImpl.getOneStreetByID(p.getStreet_id());
		Map m = mapServiceImpl.getOneByMapID(p.getMapID());
		RoleOfPlace r = roleOfPlaceServiceImpl.getRoleByID(p.getRoleOfPlaceID());

		PlaceDetail pd = new PlaceDetail();
		pd.setAddress(p.getAddress());
		pd.setArea(p.getArea());
		pd.setBedRooms(p.getBedRooms());
		pd.setCounterView(p.getCounterView());
		pd.setDescription(p.getDescription());
		pd.setDistrict(d.getDistrict());
		pd.setFrontispiece(p.getFrontispiece());
		pd.setHomeDirection(p.getHomeDirection());
		pd.setImageLarge(p.getImage_large());
		pd.setLatitude(m.getLatitude());
		pd.setLongtitude(m.getLongtitude());
		pd.setPlaceID(p.getPlaceID());
		pd.setPrice(p.getPrice());
		pd.setRoleOfPlace(r.getRoleName());
		pd.setStreet(s.getStreetName());
		pd.setTitle(p.getTitle());
		pd.setToilets(p.getToilets());
		pd.setWard(w.getWard_name());

		return pd;
	}

//	@GetMapping("/places/search")
//	public List<PlaceQuickView> searchPlace(@RequestParam("title") String title,
//			@RequestParam("district_id") int district_id, @RequestParam("role_id") int role_id,
//			@RequestParam("mina") float mina, @RequestParam("maxa") float maxa, @RequestParam("minp") float minp,
//			@RequestParam("maxp") float maxp) {
//		String formatTitle = "";
//		if (!title.equals("")) {
//			formatTitle = "%" + title + "%";
//		}
//
//		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, district_id, role_id, mina, maxa, minp, maxp);
//
//		return getPlaceQuickView(listP);
//	}
	
	
	
	@PostMapping("/places/search")
	public List<PlaceQuickView> searchPlace(@Valid @RequestBody SearchCondition cond) {
		String formatTitle = "";
		if (!cond.getTitle().equals("")) {
			formatTitle = "%" + cond.getTitle() + "%";
		}

		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, cond.getDistrictID(), cond.getRoleOfPlaceID(),
				 cond.getAreaMin(),cond.getAreaMax(), cond.getPriceMin(), cond.getPriceMax());

		return getPlaceQuickView(listP);
	}
	

	public List<PlaceQuickView> getPlaceQuickView(List<Place> listP) {

		List<PlaceQuickView> list = new ArrayList<>();
		List<RoleOfPlace> listR = roleOfPlaceServiceImpl.getAllRole();
		List<DistrictDB> listD = districtDBServiceImpl.listArea();

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

}
