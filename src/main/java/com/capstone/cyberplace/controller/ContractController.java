package com.capstone.cyberplace.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.form.InsertedContractForm;
import com.capstone.cyberplace.model.Contract;
import com.capstone.cyberplace.model.CostOfLivingBill;
import com.capstone.cyberplace.model.CostOfPlace;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.service.impl.ContractServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillDetailServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	private ContractServiceImpl contractServiceImpl;

	@Autowired
	private CostOfLivingBillServiceImpl costOfLivingBillServiceImpl;

	@Autowired
	private CostOfPlaceServiceImpl costOfPlaceServiceImpl;

	@Autowired
	private CostOfLivingBillDetailServiceImpl detailServiceImpl;

	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@PostMapping("/insert")
	public boolean insert(@Valid @RequestBody InsertedContractForm form) {

		if (form != null && form.getIsUseService() == 1) {
			try {
				contractServiceImpl.insertContract(form.getOwnerID(), form.getRenterID(), form.getPlaceID(),
						form.getStartDate(), form.getEndDate(), form.getFee(), form.getContractStatusID(),
						form.getOrderID(), form.getIsUseService(), form.getContractLink());
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

		Contract c = contractServiceImpl.getContractByContractID(contractID);

		try {
			contractServiceImpl.changeStatusContractByContractID(contractStatusID, contractID);

			if (contractStatusID == CommonConstant.Contract_Status_ID_Active && c.getIsUseService() == 1) {
				insertBill(contractServiceImpl.getContractByContractID(contractID));

				insertBillDetail(contractID);
			}
		} catch (Exception e) {
			System.err.print(e);
			return false;
		}

		return true;
	}

	// -------------------------

	public void insertBill(Contract c) {

		String startDate = String.valueOf(c.getStartDate());

		String endDate = String.valueOf(c.getEndDate());

		String[] startSplit = startDate.split("-");
		String[] endSplit = endDate.split("-");
		LocalDate sDate = LocalDate.of(Integer.parseInt(startSplit[0]), Integer.parseInt(startSplit[1]),
				Integer.parseInt(startSplit[2]));
		LocalDate eDate = LocalDate.of(Integer.parseInt(endSplit[0]), Integer.parseInt(endSplit[1]),
				Integer.parseInt(endSplit[2]));

		Period different = Period.between(sDate, eDate);

		int totalDay = different.getYears() * 365 + different.getMonths() * 30 + different.getDays();

		int times = totalDay / 30;

		List<CostOfPlace> listCost = costOfPlaceServiceImpl.getListCostByPlaceID(c.getPlaceID());
		Place p = placeServiceImpl.getPlaceByPlaceID(c.getPlaceID());

		float hardCostInMonth = 0;
		if (p != null) {
			hardCostInMonth += p.getPrice();
		}
		for (CostOfPlace cost : listCost) {
			if (cost.getUnitID() == 2) {
				hardCostInMonth += cost.getCostPrice();
			}
		}

		Calendar calStart = Calendar.getInstance();
		calStart.set(Integer.parseInt(startSplit[0]), Integer.parseInt(startSplit[1]), Integer.parseInt(startSplit[2]));
		for (int i = 1; i < times + 1; i++) {
			calStart.add(Calendar.MONTH, 1);
			// calStart.roll(Calendar.MONTH, true);
			int year = calStart.get(Calendar.YEAR);
			int month = calStart.get(Calendar.MONTH);
			int day = calStart.get(Calendar.DAY_OF_MONTH);
			if (month == 0) {
				month = 12;
			}
			LocalDate nextDate = LocalDate.of(year, month, day);
			Period differ = Period.between(nextDate, eDate);
			int compare = differ.getYears() * 365 + differ.getMonths() * 30 + differ.getDays();
			if (compare != 0) {
				String date = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
				costOfLivingBillServiceImpl.insertCostOfLivingBill(c.getContractID(), date, hardCostInMonth,
						CommonConstant.Payment_Status_ID_Not_Process);
			}
			if (compare == 0) {
				String date = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
				costOfLivingBillServiceImpl.insertCostOfLivingBill(c.getContractID(), date, hardCostInMonth,
						CommonConstant.Payment_Status_ID_Not_Process);
				break;
			}

		}

	}

	public void insertBillDetail(int contractID) {
		Contract c = contractServiceImpl.getContractByContractID(contractID);
		List<CostOfLivingBill> listBill = costOfLivingBillServiceImpl.getAllBillByContractID(c.getContractID());

		List<CostOfPlace> listCost = costOfPlaceServiceImpl.getListCostByPlaceID(c.getPlaceID());
		if (listBill != null) {
			for (CostOfLivingBill bill : listBill) {

				if (listCost != null) {
					for (CostOfPlace cost : listCost) {
						if (cost.getUnitID() == 1) {
							try {
								detailServiceImpl.insertCostOfLivingBillDetail(bill.getColID(), cost.getId(), 0, 0);
							} catch (Exception e) {
								System.out.print(e);
							}

						}
					}
				}

			}
		}

	}

}
