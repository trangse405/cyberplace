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
import com.capstone.cyberplace.service.impl.ContractServiceImpl;
import com.capstone.cyberplace.service.impl.ContractStatusServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

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

	@GetMapping("/get-all-contract")
	public List<ManageContractForm> getAllContract() {

		List<ManageContractForm> list = new ArrayList<ManageContractForm>();
		List<Place> listP = placeServiceImpl.getAllPlace();
		List<ContractStatus> listCS = contractStatusServiceImpl.getAllContractStatus();
		List<Contract> listC = contractServiceImpl.getAllContract();
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
				for (ContractStatus cs : listCS) {
					if (c.getContractStatusID() == cs.getContractStatusID()) {
						f.setStatusContract(cs.getContractStatusName());
					}
				}
				for (Place p : listP) {
					if (c.getPlaceID() == p.getPlaceID()) {
						f.setTitlePlace(p.getTitle());
					}
				}
				list.add(f);
			}

		}

		return list;
	}

	@GetMapping("/get-all-contract-ownerID")
	public List<ManageContractForm> getAllContractByOwnerID(@RequestParam("ownerID") int ownerID) {

		List<ManageContractForm> list = new ArrayList<ManageContractForm>();
		List<Place> listP = placeServiceImpl.getAllPlace();
		List<ContractStatus> listCS = contractStatusServiceImpl.getAllContractStatus();
		List<Contract> listC = contractServiceImpl.getAllContractByOwnerID(ownerID);
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
				for (ContractStatus cs : listCS) {
					if (c.getContractStatusID() == cs.getContractStatusID()) {
						f.setStatusContract(cs.getContractStatusName());
					}
				}
				for (Place p : listP) {
					if (c.getPlaceID() == p.getPlaceID()) {
						f.setTitlePlace(p.getTitle());
					}
				}
				list.add(f);
			}

		}

		return list;
	}

}
