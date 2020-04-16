package com.capstone.cyberplace.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.ManageContractForm;
import com.capstone.cyberplace.model.CheckingList;
import com.capstone.cyberplace.model.Contract;
import com.capstone.cyberplace.model.ContractStatus;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.StatusPlace;
import com.capstone.cyberplace.service.impl.ContractServiceImpl;
import com.capstone.cyberplace.service.impl.ContractStatusServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.StatusPlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/managecontract")
public class ManageContractController {

	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	@Autowired
	private ContractStatusServiceImpl contractStatusServiceImpl;
	@Autowired
	private ContractServiceImpl contractServiceImpl;

	@Autowired
	private StatusPlaceServiceImpl statusPlaceServiceImpl;

	@GetMapping("/get-all-contract")
	public List<ManageContractForm> getAllContract() {

		List<ManageContractForm> list = new ArrayList<ManageContractForm>();
		List<Place> listP = placeServiceImpl.getAllPlace();
		List<ContractStatus> listCS = contractStatusServiceImpl.getAllContractStatus();
		List<Contract> listC = contractServiceImpl.getAllContract();
		List<StatusPlace> listStatusPlace = statusPlaceServiceImpl.getAllStatusPlace();
		if (listC != null) {

			for (Contract c : listC) {
				ManageContractForm f = new ManageContractForm();
				f.setContractID(c.getContractID());
				f.setContractStatusID(c.getContractStatusID());
				f.setEndDate(String.valueOf(c.getEndDate()));
				f.setStartDate(String.valueOf(c.getStartDate()));
				f.setFee(c.getFee());
				f.setOwnerID(c.getOwnerID());
				f.setRenterID(c.getRenterID());
				f.setPlaceID(c.getPlaceID());
				f.setOrderID(c.getOrderID());

				for (ContractStatus cs : listCS) {
					if (c.getContractStatusID() == cs.getContractStatusID()) {
						f.setStatusContract(cs.getContractStatusName());
					}
				}
				for (Place p : listP) {
					if (c.getPlaceID() == p.getPlaceID()) {
						f.setTitlePlace(p.getTitle());

						for (StatusPlace st : listStatusPlace) {
							if (p.getStatusPlaceID() == st.getStatusPlaceID()) {
								f.setPlaceStatus(st.getStatus());
							}
						}
					}
				}
				list.add(f);
			}

		}

		return list;
	}

	@GetMapping("/get-all-contract-ownerID")
	public List<ManageContractForm> getAllContractByOwnerID(@RequestParam("ownerID") int ownerID) {

		List<Contract> listC = contractServiceImpl.getAllContractByOwnerID(ownerID);
		if (listC != null) {

			return getListContract(listC, ownerID);
		}

		return null;
	}
	
	@GetMapping("/get-all-contract-renterID")
	public List<ManageContractForm> getAllContractByRenterID(@RequestParam("renterID") int renterID) {

		List<Contract> listC = contractServiceImpl.getAllContractByRenterID(renterID);
		if (listC != null) {

			return getListContract(listC, renterID);
		}

		return null;
	}

	// -------------------------------------------------------------------

	// get manage contract form by user id
	public List<ManageContractForm> getListContract(List<Contract> listC, int userID) {
		List<ManageContractForm> list = new ArrayList<ManageContractForm>();

		List<Place> listP = placeServiceImpl.getAllPlace();
		List<ContractStatus> listCS = contractStatusServiceImpl.getAllContractStatus();
		List<StatusPlace> listStatusPlace = statusPlaceServiceImpl.getAllStatusPlace();
		if (listC != null) {

			for (Contract c : listC) {
				ManageContractForm f = new ManageContractForm();
				f.setContractID(c.getContractID());
				f.setContractStatusID(c.getContractStatusID());
				f.setEndDate(String.valueOf(c.getEndDate()));
				f.setStartDate(String.valueOf(c.getStartDate()));
				f.setFee(c.getFee());
				f.setOwnerID(c.getOwnerID());
				f.setRenterID(c.getRenterID());
				f.setPlaceID(c.getPlaceID());
				f.setOrderID(c.getOrderID());
				for (ContractStatus cs : listCS) {
					if (c.getContractStatusID() == cs.getContractStatusID()) {
						f.setStatusContract(cs.getContractStatusName());
					}
				}
				for (Place p : listP) {
					if (c.getPlaceID() == p.getPlaceID()) {
						f.setTitlePlace(p.getTitle());
						for (StatusPlace st : listStatusPlace) {
							if (p.getStatusPlaceID() == st.getStatusPlaceID()) {
								f.setPlaceStatus(st.getStatus());
							}
						}
					}
				}
				list.add(f);
			}

		}

		return list;
	}

}
