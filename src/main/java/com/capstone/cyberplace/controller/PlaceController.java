package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.PlaceDetail;
import com.capstone.cyberplace.dto.PlaceQuickView;
import com.capstone.cyberplace.dto.SearchCondition;
import com.capstone.cyberplace.dto.SearchConditionPage;
import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.model.ImageLink;
import com.capstone.cyberplace.model.Map;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.model.WardDB;
import com.capstone.cyberplace.repository.PlaceRepository;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;
import com.capstone.cyberplace.service.impl.ImageLinkServiceImpl;
import com.capstone.cyberplace.service.impl.MapServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.RoleOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StreetDBServiceImpl;
import com.capstone.cyberplace.service.impl.WardDBServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cp")
public class PlaceController {

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

	@Autowired
	private PlaceRepository placerepository;

	@Autowired
	private ImageLinkServiceImpl imageLinkServiceImpl;

	@GetMapping("/places/top6")
	public List<PlaceQuickView> getTop6() {

		List<Place> listP = placeServiceImpl.getTop6();

		return getPlaceQuickView(listP);
	}

	@GetMapping("/places/page")
	public Page<Place> getPagePlace(@RequestParam("page") int page, @RequestParam("number") int number) {

		Pageable pageable = PageRequest.of(page, number);

		return placerepository.getAllPageable(pageable);
	}

	// kiểm tra status của 1 place
	@GetMapping("/places/checkplace")
	public int checkPlace(@RequestParam("placeid") int placeID) {

		Place p = placeServiceImpl.checkPlace(placeID);

		// trả về status tương ứng
		return p.getStatusPlaceID();

	}

	// kéo ra tất cả place
	@GetMapping("/places/all")
	public List<PlaceQuickView> getAll() {

		List<Place> listP = placeServiceImpl.getAll();

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

	@GetMapping("/places/images/{id}")
	public List<String> getListImageLinkByPlaceID(@PathVariable int id) {

		List<ImageLink> listImage = imageLinkServiceImpl.getListImageByPlaceID(id);
		List<String> list = new ArrayList<String>();
		for (ImageLink im : listImage) {
			list.add(im.getImage_link());
		}
		return list;
	}

	@PostMapping("/places/search")
	public List<PlaceQuickView> searchPlace(@Valid @RequestBody SearchCondition cond) {
		String formatTitle = "";
		if (!cond.getTitle().equals("")) {
			formatTitle = "%" + cond.getTitle() + "%";
		}

		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, cond.getDistrictID(), cond.getRoleOfPlaceID(),
				cond.getAreaMin(), cond.getAreaMax(), cond.getPriceMin(), cond.getPriceMax());

		return getPlaceQuickView(listP);
	}

	@PostMapping("/places/search-page")
	public Page<PlaceQuickView> searchPagePlace(@Valid @RequestBody SearchConditionPage cond) {
		String formatTitle = "";
		if (!cond.getTitle().equals("")) {
			formatTitle = "%" + cond.getTitle() + "%";
		}
		Pageable pageable = PageRequest.of(cond.getPage(), cond.getNumber());

		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, cond.getDistrictID(), cond.getRoleOfPlaceID(),
				cond.getAreaMin(), cond.getAreaMax(), cond.getPriceMin(), cond.getPriceMax());

		List<PlaceQuickView> listContent = getPlaceQuickView(listP);

		return toPage(listContent, pageable);
	}

	@PostMapping("/places/count-search-result")
	public int counter(@Valid @RequestBody SearchConditionPage cond) {
		String formatTitle = "";
		if (!cond.getTitle().equals("")) {
			formatTitle = "%" + cond.getTitle() + "%";
		}

		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, cond.getDistrictID(), cond.getRoleOfPlaceID(),
				cond.getAreaMin(), cond.getAreaMax(), cond.getPriceMin(), cond.getPriceMax());

		return listP.size();
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

	//////////////////////////////////////////////////////////////////////////

	private Page<PlaceQuickView> toPage(List<PlaceQuickView> list, Pageable pageable) {
		if (pageable.getOffset() >= list.size()) {
			return Page.empty();
		}
		int startIndex = (int) pageable.getOffset();
		int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());
		List subList = list.subList(startIndex, endIndex);
		return new PageImpl(subList, pageable, list.size());
	}

}
