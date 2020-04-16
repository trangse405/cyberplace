package com.capstone.cyberplace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.InsertedContractForm;
import com.capstone.cyberplace.service.impl.ContractServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	private ContractServiceImpl contractServiceImpl;

	@PostMapping("/insert")
	public boolean insert(@Valid @RequestBody InsertedContractForm form) {

		if (form != null) {
			try {
				contractServiceImpl.insertContract(form.getOwnerID(), form.getRenterID(), form.getPlaceID(),
						form.getStartDate(), form.getEndDate(), form.getFee(), form.getContractStatusID(),
						form.getOrderID());
			} catch (Exception e) {
				System.err.print("insert err");
				return false;
			}

		}

		return true;
	}

	@PostMapping("/change-status")
	public boolean changeStatusContract(@RequestParam("contractStatusID") int contractStatusID,
			@RequestParam("contractID") int contractID) {

		try {
			contractServiceImpl.changeStatusContractByContractID(contractStatusID, contractID);

		} catch (Exception e) {
			System.err.print("change err");
			return false;
		}

		return true;
	}

}
