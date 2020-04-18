package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.capstone.cyberplace.dto.SearchCondition;
import com.capstone.cyberplace.dto.StreetData;
import com.capstone.cyberplace.dto.WardData;
import com.capstone.cyberplace.dto.form.CostOfPlaceForm;
import com.capstone.cyberplace.dto.form.EquipmentListForm;
import com.capstone.cyberplace.dto.form.FillToUpdateForm;
import com.capstone.cyberplace.dto.form.PostPlaceForm;
import com.capstone.cyberplace.dto.form.UpdatePlaceForm;
import com.capstone.cyberplace.model.CheckingList;
import com.capstone.cyberplace.model.CostOfPlace;
import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.model.EquipmentList;
import com.capstone.cyberplace.model.ImageLink;
import com.capstone.cyberplace.model.Map;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.model.WardDB;
import com.capstone.cyberplace.repository.PlaceRepository;
import com.capstone.cyberplace.service.impl.CheckingListServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;
import com.capstone.cyberplace.service.impl.EquipmentListServiceImpl;
import com.capstone.cyberplace.service.impl.ImageLinkServiceImpl;
import com.capstone.cyberplace.service.impl.MapServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.RoleOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;
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

	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;

	@Autowired
	private CostOfPlaceServiceImpl costOfPlaceServiceImpl;

	@Autowired
	public JavaMailSender emailSender;

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

		Place p = placeServiceImpl.getPlaceByPlaceID(placeID);

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

	// ---------------------test function with place id =2------------------
	@GetMapping("/places/test")
	public List<Place> test() {
		List<Place> listP = placeServiceImpl.getTop6();
		Map m = mapServiceImpl.getMapIDByPlaceID(22);
		List<Map> listM = mapServiceImpl.getAllMap();
		return listP;
	}

	/*
	 * trả thông tin cho trang update place
	 */
	@GetMapping("/places/fillupdate")
	public FillToUpdateForm fillDataToUpdatePlaceForm(@RequestParam("placeid") int placeID) {

		FillToUpdateForm form = new FillToUpdateForm();
		Place p = placerepository.getPlaceByPlaceID(placeID);

		// convertPlaceToPost(p, ps);
		// get list image link
		List<ImageLink> listS = imageLinkServiceImpl.getListImageByPlaceID(placeID);
		List<String> list = new ArrayList<String>();
		if (listS != null) {

			for (ImageLink i : listS) {
				list.add(i.getImage_link());
			}

		}
		form.setListImageLink(list);

		// get equipment list
		List<EquipmentList> listE = equipmentListServiceImpl.getListEquipByPlaceID(placeID);

		List<EquipmentListForm> listEQ = new ArrayList<EquipmentListForm>();
		if (listE != null) {
			for (EquipmentList e : listE) {
				EquipmentListForm eq = new EquipmentListForm();
				eq.setName(e.getEquipmentName());
				eq.setPrice(e.getPrice());
				eq.setLikeNew(e.getLikeNew());
				eq.setQuantity(e.getQuantity());
				eq.setEquipmentDescrible(e.getEquipmentDescribe());
				listEQ.add(eq);
			}
		}

		// get check time meeing

		String checkedDate = "";
		CheckingList checked = checkingListServiceImpl.getCheckingByPlaceID(placeID);
		if (checked != null) {
			checkedDate = checked.getDateTime().toString();
		}

		// get map infor

		Map m = mapServiceImpl.getMapIDByPlaceID(p.getPlaceID());
		if (m != null) {
			form.setLatitude(m.getLatitude());
			form.setLongtitude(m.getLongtitude());
		}
		List<CostOfPlaceForm> listCostForm = new ArrayList<CostOfPlaceForm>();
		List<CostOfPlace> listCost = costOfPlaceServiceImpl.getListCostByPlaceID(placeID);
		if (listCost != null) {
			for (CostOfPlace cost : listCost) {
				CostOfPlaceForm f = new CostOfPlaceForm();
				f.setCostName(cost.getCostName());
				f.setCostPrice(cost.getCostPrice());
				f.setUnitID(cost.getUnitID());
				listCostForm.add(f);
			}
		}
		// fill form
		form.setListCost(listCostForm);
		form.setListEquip(listEQ);

		form.setCheckingDate(checkedDate);

		form.setAddressDetail(p.getAddress());

		form.setArea(p.getArea());
		form.setContactAddress(p.getContactAddress());
		form.setContactName(p.getContactName());
		form.setPhoneNumber(p.getContactPhoneNumber());
		form.setEmail(p.getContactEmail());
		form.setDescriptions(p.getDescription());

		form.setFrontispiece(p.getFrontispiece());
		form.setNumberFloors(p.getFloors());
		form.setHomeDirection(p.getHomeDirection());
		form.setNumberBedrooms(p.getBedRooms());
		form.setNumberToilets(p.getToilets());
		form.setTitle(p.getTitle());
		form.setPrice(p.getPrice());
		form.setRoleOfPlaceID(p.getRoleOfPlaceID());

		DistrictDB district = districtDBServiceImpl.getOneDistrictByID(p.getDistrict_id());
		if (district != null) {
			form.setDistrict(district);
		}
		WardDB ward = wardDBServiceImpl.getOneWardByID(p.getWard_id());
		if (ward != null) {

			WardData wardData = new WardData(ward.getId(), ward.getWard_name(), ward.getWardLatitude(),
					ward.getWardLongitude());
			form.setWard(wardData);
		}
		StreetDB street = streetDBServiceImpl.getOneStreetByID(p.getStreet_id());
		if (street != null) {

			StreetData streetData = new StreetData(street.getId(), street.getStreetName());
			form.setStreet(streetData);
		}

		return form;
	}

	/*
	 * update place
	 */
	@PostMapping("/places/update")
	public boolean updatePlace(@Valid @RequestBody UpdatePlaceForm form) {

		try {
			placeServiceImpl.updatePlace(form.getTitle(), form.getPrice(), form.getArea(), form.getDistrictID(),
					form.getWardID(), form.getStreetID(), form.getAddressDetail(), form.getRoleOfPlaceID(),
					form.getFrontispiece(), form.getHomeDirection(), form.getNumberFloors(), form.getNumberBedrooms(),
					form.getNumberToilets(), form.getDescriptions(), form.getContactName(), form.getPhoneNumber(),
					form.getContactAddress(), form.getEmail(), form.getPlaceID());

		} catch (Exception e) {
			System.out.println("update place fail");
			return false;
		}

		try {
			mapServiceImpl.updateMap(form.getLatitude(), form.getLongtitude(), form.getPlaceID());
		} catch (Exception e) {
			System.out.println("update map fail");
		}

		try {
			List<EquipmentList> listEquip = new ArrayList<EquipmentList>();
			listEquip = equipmentListServiceImpl.getListEquipByPlaceID(form.getPlaceID());
			if (listEquip != null) {
				equipmentListServiceImpl.deleteListEquipByPlaceID(form.getPlaceID());
			}

			if (form.getListEquip() != null && !form.getListEquip().isEmpty()) {
				try {
					for (EquipmentListForm item : form.getListEquip()) {
						equipmentListServiceImpl.insertEquipmentItem(form.getPlaceID(), item.getName(),
								item.getQuantity(), item.getPrice(), item.getLikeNew(), item.getEquipmentDescrible());

					}
				} catch (Exception e) {
					System.out.print("insert equip error");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("delete equip fail");
		}

		try {
			List<CostOfPlace> listCost = new ArrayList<CostOfPlace>();
			listCost = costOfPlaceServiceImpl.getListCostByPlaceID(form.getPlaceID());
			if (listCost != null) {
				costOfPlaceServiceImpl.deleteListCostByPlaceID(form.getPlaceID());
			}

			if (form.getListCost() != null && !form.getListCost().isEmpty()) {
				try {
					for (CostOfPlaceForm f : form.getListCost()) {
						costOfPlaceServiceImpl.insertItemCostOfPlace(form.getPlaceID(), f.getCostName(),
								f.getCostPrice(), f.getUnitID());
					}
				} catch (Exception e) {
					System.out.print("insert cost error");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println("delete cost fail");
			return false;
		}

		try {

			List<ImageLink> listImage = new ArrayList<ImageLink>();
			listImage = imageLinkServiceImpl.getListImageByPlaceID(form.getPlaceID());
			if (listImage != null) {
				imageLinkServiceImpl.deleteListImageByPlaceID(form.getPlaceID());
			}

			if (form.getListImageLink() != null && !form.getListImageLink().isEmpty()) {
				try {
					for (String s : form.getListImageLink()) {
						imageLinkServiceImpl.insertImageLink(form.getPlaceID(), s);
					}
				} catch (Exception e) {
					System.out.print("insert image link error");
					return false;
				}

			}
		} catch (Exception e) {
			System.out.println("delete image fail");
		}

		try {
			checkingListServiceImpl.updateItemCheckingList(form.getPlaceID(), form.getCheckingDate());
		} catch (Exception e) {
			System.out.print("update check list error");
			return false;
		}

		return true;
	}

	// ---------------------------------------

	/*
	 * trả về chi tiết place theo ID
	 */
	@GetMapping("/places/{id}")
	public PlaceDetail getOneById(@PathVariable int id) {

		List<StatusPlace> list = statusPlaceServiceImpl.getAllStatusPlace();

		Place p = new Place();

		p = placeServiceImpl.getOneActiveByPlaceID(id);
		if (p != null) {
			PlaceDetail pd = new PlaceDetail();
			DistrictDB d = districtDBServiceImpl.getOneDistrictByID(p.getDistrict_id());
			if (d != null) {
				pd.setDistrict(d.getDistrict());
			}
			WardDB w = wardDBServiceImpl.getOneWardByID(p.getWard_id());
			if (w != null) {
				pd.setWard(w.getWard_name());
			}
			StreetDB s = streetDBServiceImpl.getOneStreetByID(p.getStreet_id());
			if (s != null) {
				pd.setStreet(s.getStreetName());
			}
			Map m = mapServiceImpl.getMapIDByPlaceID(id);
			if (m != null) {
				pd.setLatitude(m.getLatitude());
				pd.setLongtitude(m.getLongtitude());
			}
			RoleOfPlace r = roleOfPlaceServiceImpl.getRoleByID(p.getRoleOfPlaceID());
			// get list Image
			List<ImageLink> listE = new ArrayList<ImageLink>();
			List<String> listImage = getListImageForDetail(listE, id);
			// get list equip
			List<EquipmentList> listEq = new ArrayList<EquipmentList>();
			List<EquipmentListForm> listF = getListEquipForDetail(listEq, id);
			// get list cost
			List<CostOfPlace> listCostOfPlace = new ArrayList<CostOfPlace>();
			List<CostOfPlaceForm> listCostForm = getListCostForDetail(listCostOfPlace, id);

			pd.setAddress(p.getAddress());
			pd.setArea(p.getArea());
			pd.setBedRooms(p.getBedRooms());
			pd.setCounterView(p.getCounterView());
			pd.setDescription(p.getDescription());
			pd.setStatusPlaceID(p.getStatusPlaceID());
			pd.setListCost(listCostForm);

			for (StatusPlace sp : list) {
				if (p.getStatusPlaceID() == sp.getStatusPlaceID()) {
					pd.setStatusPlace(sp.getStatus());
				}
			}

			pd.setFrontispiece(p.getFrontispiece());
			pd.setHomeDirection(p.getHomeDirection());
			pd.setImageLarge(p.getImage_large());

			pd.setPlaceID(p.getPlaceID());
			pd.setPrice(p.getPrice());
			pd.setRoleOfPlace(r.getRoleName());

			pd.setTitle(p.getTitle());
			pd.setToilets(p.getToilets());

			pd.setListImage(listImage);
			pd.setListEquip(listF);
			return pd;
		}

		return null;
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
	public boolean insertPlace(@Valid @RequestBody PostPlaceForm form) throws MessagingException {

		int placeID = getPlaceIDAfterInserted(form);

		if (form.getListEquip() != null && !form.getListEquip().isEmpty()) {
			try {
				for (EquipmentListForm item : form.getListEquip()) {
					equipmentListServiceImpl.insertEquipmentItem(placeID, item.getName(), item.getQuantity(),
							item.getPrice(), item.getLikeNew(), item.getEquipmentDescrible());

				}
			} catch (Exception e) {
				System.out.print("insert equip error");
				return false;
			}
		}
		if (form.getListImageLink() != null && !form.getListImageLink().isEmpty()) {
			try {
				for (String s : form.getListImageLink()) {
					imageLinkServiceImpl.insertImageLink(placeID, s);
				}
			} catch (Exception e) {
				System.out.print("insert image link error");
				return false;
			}

		}
		if (form.getListCost() != null && !form.getListCost().isEmpty()) {
			try {
				for (CostOfPlaceForm c : form.getListCost()) {
					costOfPlaceServiceImpl.insertItemCostOfPlace(placeID, c.getCostName(), c.getCostPrice(),
							c.getUnitID());
				}
			} catch (Exception e) {
				System.out.print("insert cost  error");
				return false;
			}
		}

		try {
			checkingListServiceImpl.insertItemToCheckingList(placeID, form.getCheckingDate(),
					CommonConstant.Checking_Status_ID_Pending);
		} catch (Exception e) {
			System.out.print("insert checking error");
			return false;
		}

		try {
			mapServiceImpl.insertMap(form.getLongtitude(), form.getLatitude(), placeID);
		} catch (Exception e) {
			System.out.print("insert checking error");
			return false;
		}
		sendEmail(form.getEmail());

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
		List<Map> listM = mapServiceImpl.getAllMap();

		for (Place p : listP) {
			PlaceQuickView item = new PlaceQuickView();
			item.setArea(p.getArea());
			item.setImageLarge(p.getImage_large());
			item.setPlaceID(p.getPlaceID());
			item.setPrice(p.getPrice());
			item.setBedRooms(p.getBedRooms());
			item.setTitle(p.getTitle());
			item.setToilets(p.getToilets());
			for (RoleOfPlace rop : listR) {
				if (rop.getRoleOfPlaceID() == p.getRoleOfPlaceID()) {
					item.setRoleOfPlaceName(rop.getRoleName());

				}
				for (DistrictDB d : listD) {
					if (p.getDistrict_id() == d.getId()) {
						item.setDistrict(d.getDistrict());
					}
				}
				for (Map m : listM) {
					if (p.getPlaceID() == m.getPlaceID()) {
						item.setLatitude(m.getLatitude());
						item.setLongtitude(m.getLongtitude());
					}
				}
			}
			list.add(item);
		}

		return list;
	}

	/*
	 * lấy ra place id sau khi insert thông tin vào bảng place
	 */
	public int getPlaceIDAfterInserted(PostPlaceForm form) {

		try {
			Place p = new Place();
			p.setOwnerID(form.getUserID());
			p.setTitle(form.getTitle());
			p.setPrice(form.getPrice());
			p.setArea(form.getArea());
			p.setDistrict_id(form.getDistrictID());
			p.setWard_id(form.getWardID());
			p.setStreet_id(form.getStreetID());
			p.setAddress(form.getAddressDetail());
			p.setRoleOfPlaceID(form.getRoleOfPlaceID());
			p.setStatusPlaceID(CommonConstant.Place_Status_ID_Pending);
			p.setCounterView(0);
			p.setFrontispiece(form.getFrontispiece());
			p.setHomeDirection(form.getHomeDirection());
			p.setFloors(form.getNumberFloors());
			p.setBedRooms(form.getNumberBedrooms());
			p.setToilets(form.getNumberToilets());
			p.setDescription(form.getDescriptions());
			p.setImage_large(form.getListImageLink().get(0));
			p.setContactAddress(form.getContactAddress());
			p.setContactName(form.getContactName());
			p.setContactPhoneNumber(form.getPhoneNumber());
			p.setContactEmail(form.getEmail());
			p.setDatePost(String.valueOf(java.time.LocalDate.now()));
			p = placerepository.save(p);
			placerepository.flush();

			return p.getPlaceID();

		} catch (Exception e) {
			System.out.print("insert place error");
		}

		return -1;
	}

	/*
	 * đổ thông tin place ra post để update
	 */
	public void convertPlaceToPost(Place p, PostPlaceForm pf) {

		pf.setAddressDetail(p.getAddress());

		pf.setArea(p.getArea());
		pf.setContactAddress(p.getContactAddress());
		pf.setContactName(p.getContactName());
		pf.setPhoneNumber(p.getContactPhoneNumber());
		pf.setEmail(p.getContactEmail());
		pf.setDescriptions(p.getDescription());
		pf.setDistrictID(p.getDistrict_id());
		pf.setFrontispiece(p.getFrontispiece());
		pf.setNumberFloors(p.getFloors());
		pf.setHomeDirection(p.getHomeDirection());
		pf.setNumberBedrooms(p.getBedRooms());
		pf.setNumberToilets(p.getToilets());
		pf.setTitle(p.getTitle());
		pf.setPrice(p.getPrice());
		pf.setRoleOfPlaceID(p.getRoleOfPlaceID());
		pf.setStreetID(p.getStreet_id());
		pf.setWardID(p.getWard_id());

	}

	// get list Image for place detail
	public List<String> getListImageForDetail(List<ImageLink> listI, int placeID) {
		listI = imageLinkServiceImpl.getListImageByPlaceID(placeID);

		List<String> list = new ArrayList<>();
		if (listI != null) {
			for (ImageLink i : listI) {
				list.add(i.getImage_link());
			}
		}

		return list;
	}

	// get list equip for place detail
	public List<EquipmentListForm> getListEquipForDetail(List<EquipmentList> listE, int placeID) {

		listE = equipmentListServiceImpl.getListEquipByPlaceID(placeID);

		List<EquipmentListForm> list = new ArrayList<EquipmentListForm>();
		if (listE != null) {
			for (EquipmentList e : listE) {
				EquipmentListForm f = new EquipmentListForm();
				f.setEquipmentDescrible(e.getEquipmentDescribe());
				f.setLikeNew(e.getLikeNew());
				f.setName(e.getEquipmentName());
				f.setPrice(e.getPrice());
				f.setQuantity(e.getQuantity());
				list.add(f);

			}
		}

		return list;

	}
	// get list cost for place detail

	public List<CostOfPlaceForm> getListCostForDetail(List<CostOfPlace> listC, int placeID) {

		listC = costOfPlaceServiceImpl.getListCostByPlaceID(placeID);

		List<CostOfPlaceForm> list = new ArrayList<CostOfPlaceForm>();
		if (listC != null) {
			for (CostOfPlace c : listC) {
				CostOfPlaceForm f = new CostOfPlaceForm();
				f.setCostName(c.getCostName());
				f.setCostPrice(c.getCostPrice());
				f.setUnitID(c.getUnitID());
				list.add(f);

			}
		}

		return list;

	}

	// send email
	public void sendEmail(String receiver) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();
		boolean multipart = true;
		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
		String htmlMsg = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>" + "<meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
				+ "</head>\r\n" + "<body>\r\n" + "<div>\r\n" + "  <div>Xin chào <b>Abc</b>,</div>\r\n"
				+ "<div><b><br></b></div>\r\n"
				+ "    &emsp;&emsp; Hệ thống <span class=\"badge badge-info\">CyberPlace</span> xác nhận bạn đã đăng tin <b>\"Nhà Mỹ Đình 3 - CCMN\"&nbsp;</b>\r\n"
				+ "    <div>Thời gian kiểm tra nhà: <b>10/05/2020 - 09:30SA</b></div>\r\n"
				+ "            <div>Chúng tôi sẽ liên lạc với bạn qua số điện thoại. Xin vui lòng để ý cuộc gọi tới của bạn.</div>\r\n"
				+ "    <div><br></div>\r\n" + "   <div>Cảm ơn bạn.</div>\r\n"
				+ "   <div>__________________________<br><b>CYBER PLACE&nbsp;</b></div><div><b>Address</b>: FPT University</div><div><b>Email</b>:&nbsp;cybermanager99@gmail.com</div>\r\n"
				+ "</div>" + "</body>\r\n" + "</html>";

		message.setContent(htmlMsg, "text/html");
		helper.setTo(receiver);

		helper.setSubject("Xác nhận đăng tin");

		this.emailSender.send(message);
		// SimpleMailMessage message = new SimpleMailMessage();

//        message.setTo(receiver);
//        message.setSubject("Hệ thống xác nhận");
//        message.setText("Hệ thống xác nhận bạn đã book lịch đặt nhà ");

		// Send Message!
		// this.emailSender.send(message);
	}

}
