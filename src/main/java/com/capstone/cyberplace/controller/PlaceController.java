package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.PlaceDetail;
import com.capstone.cyberplace.dto.PlaceQuickView;
import com.capstone.cyberplace.dto.form.PostPlaceForm;
import com.capstone.cyberplace.dto.SearchCondition;
import com.capstone.cyberplace.dto.form.EquipmentListForm;
import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.model.EquipmentList;
import com.capstone.cyberplace.model.ImageLink;
import com.capstone.cyberplace.model.Map;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.model.WardDB;
import com.capstone.cyberplace.repository.PlaceRepository;
import com.capstone.cyberplace.service.impl.CheckingListServiceImpl;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;
import com.capstone.cyberplace.service.impl.EquipmentListServiceImpl;
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

	@Autowired
	private EquipmentListServiceImpl equipmentListServiceImpl;

	@Autowired
	private CheckingListServiceImpl checkingListServiceImpl;

	/*
	 * trả về danh sách top 6 place active có nhiều view nhất
	 */
	@GetMapping("/places/top6")
	public List<PlaceQuickView> getTop6() {

		List<Place> listP = placeServiceImpl.getTop6();

		return getPlaceQuickView(listP);
	}

	/*
	 * trả về tất cả place có trong hệ thống (dành cho site admin)
	 */
	@GetMapping("/places/page")
	public Page<Place> getPagePlace(@RequestParam("page") int page, @RequestParam("number") int number) {

		Pageable pageable = PageRequest.of(page, number);

		return placerepository.getAllPageable(pageable);
	}

	/*
	 * trả về tất cả place đang active
	 */
	@GetMapping("/places/checkplace")
	public int checkPlace(@RequestParam("placeid") int placeID) {

		Place p = placeServiceImpl.checkPlace(placeID);

		// trả về status tương ứng
		return p.getStatusPlaceID();

	}

	/*
	 * trả về tất cả place đang active
	 */
	@GetMapping("/places/all")
	public List<PlaceQuickView> getAllActive() {

		List<Place> listP = placeServiceImpl.getAll();
		

		return getPlaceQuickView(listP);
	}
	
	//---------------------test function with place id =2------------------
	@GetMapping("/places/test")
	public PostPlaceForm test() {

		Place p = placerepository.getOneByID(2);
		List<ImageLink> listS = imageLinkServiceImpl.getListImageByPlaceID(2);
		List<String> list = new ArrayList<String>();
		for(ImageLink i : listS) {
			list.add(i.getImage_link());
		}
		List<EquipmentList>  listE = equipmentListServiceImpl.getListEquipByPlaceID(2); 
		
		List<EquipmentListForm> listEQ = new ArrayList<EquipmentListForm>();
		
		for(EquipmentList e : listE) {
			EquipmentListForm eq = new EquipmentListForm();
			eq.setName(e.getEquipmentName());
			eq.setPrice(e.getPrice());
			eq.setLikeNew(e.getLikeNew());
			eq.setQuantity(e.getQuantity());
			eq.setEquipmentDescrible(e.getEquipmentDescribe());
			listEQ.add(eq);
		}
		PostPlaceForm ps = new PostPlaceForm();
		ps.setTitle(p.getTitle());
		ps.setPrice(p.getPrice());
		ps.setListImageLink(list);
		ps.setListEquip(listEQ);

		return ps;
	}
	
	//---------------------------------------

	/*
	 * trả về chi tiết place theo ID
	 */
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

	/*
	 * trả về danh sách ảnh theo placeID
	 */
	@GetMapping("/places/images/{id}")
	public List<String> getListImageLinkByPlaceID(@PathVariable int id) {

		List<ImageLink> listImage = imageLinkServiceImpl.getListImageByPlaceID(id);
		List<String> list = new ArrayList<String>();
		for (ImageLink im : listImage) {
			list.add(im.getImage_link());
		}
		return list;
	}

	/*
	 * trả về danh sách kết quả tìm kiếm theo page
	 */

	@PostMapping("/places/search-page")
	public List<PlaceQuickView> getListSearchByPage(@Valid @RequestBody SearchCondition cond) {
		String formatTitle = "";
		if (!cond.getTitle().equals("")) {
			formatTitle = "%" + cond.getTitle() + "%";
		}
		Pageable pageable = PageRequest.of(cond.getPage(), cond.getAmount());

		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, cond.getDistrictID(), cond.getRoleOfPlaceID(),
				cond.getAreaMin(), cond.getAreaMax(), cond.getPriceMin(), cond.getPriceMax());

		List<PlaceQuickView> listContent = getPlaceQuickView(listP);

		return toPage(listContent, pageable).getContent();
	}

	/*
	 * insert các thông tin trong form rao tin
	 */
	@PostMapping("/places/insert-places")
	public boolean insertPlace(@Valid @RequestBody PostPlaceForm form) {

		int mapID = getMapIDAfterInserted(form.getLatitude(), form.getLongtitude());

		int placeID = getPlaceIDAfterInserted(form, mapID, form.getListImageLink().get(0));

		try {
			for (EquipmentListForm item : form.getListEquip()) {
				equipmentListServiceImpl.insertEquipmentItem(placeID, item.getName(), item.getQuantity(),
						item.getPrice(), item.getLikeNew(), item.getEquipmentDescrible());

			}
		} catch (Exception e) {
			System.out.print("insert equip error");
			return false;
		}

		try {	
			for (String s : form.getListImageLink()) {
				imageLinkServiceImpl.insertImageLink(placeID, s);
			}
		} catch (Exception e) {
			System.out.print("insert image link error");
			return false;
		}
		try {
			checkingListServiceImpl.insertItemToCheckingList(placeID, form.getCheckingDate(),
					CommonConstant.Checking_Status_ID_Pending);
		} catch (Exception e) {
			System.out.print("insert checking error");
			return false;
		}

		return true;
	}

	/*
	 * trả về số kết quả tìm được
	 */
	@PostMapping("/places/count-search-result")
	public int getCountSearch(@Valid @RequestBody SearchCondition cond) {
		String formatTitle = "";
		if (!cond.getTitle().equals("")) {
			formatTitle = "%" + cond.getTitle() + "%";
		}

		List<Place> listP = placeServiceImpl.searhPlace(formatTitle, cond.getDistrictID(), cond.getRoleOfPlaceID(),
				cond.getAreaMin(), cond.getAreaMax(), cond.getPriceMin(), cond.getPriceMax());

		return listP.size();
	}

	//////////////////////////////////////////////////////////////////////////
	/*
	 * xử lý phân trang
	 */
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

	/*
	 * format list place thành định dạng xem trên trang chủ
	 */
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

	/*
	 * lấy ra map id sau khi insert thông tin vào bảng map
	 */
	public int getMapIDAfterInserted(float latitude, float longtitude) {

		try {
			mapServiceImpl.insertMap(longtitude, latitude);
		} catch (Exception e) {
			System.out.print("insert map error");
		}

		Map m = mapServiceImpl.getMapIDByLongtitudeAndLatitude(latitude, longtitude);

		return m.getMapID();
	}

	/*
	 * lấy ra place id sau khi insert thông tin vào bảng place
	 */
	public int getPlaceIDAfterInserted(PostPlaceForm form, int mapID, String imageLarge) {

		try {
			placeServiceImpl.insertPlace(form.getUserID(), form.getTitle(), form.getPrice(), form.getArea(),
					form.getDistrictID(), form.getWardID(), form.getStreetID(), form.getAddressDetail(), mapID,
					form.getRoleOfPlaceID(), CommonConstant.Place_Status_ID_Pending, 0, form.getFrontispiece(),
					form.getHomeDirection(), form.getNumberFloors(), form.getNumberBedrooms(), form.getNumberToilets(),
					form.getDescriptions(), imageLarge, form.getContactName(), form.getPhoneNumber(),
					form.getContactAddress(), form.getEmail());
		} catch (Exception e) {
			System.out.print("insert place error");
		}

		Place newPlace = placeServiceImpl.getPlaceByMapID(mapID);

		return newPlace.getPlaceID();
	}

}
