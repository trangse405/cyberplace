package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.COLBill;
import com.capstone.cyberplace.model.Contract;
import com.capstone.cyberplace.model.CostOfLivingBill;
import com.capstone.cyberplace.model.PaymentStatus;
import com.capstone.cyberplace.service.impl.ContractServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillServiceImpl;
import com.capstone.cyberplace.service.impl.PaymentStatusServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/costofliving")
public class CostOfLivingBillController {

	@Autowired
	private CostOfLivingBillServiceImpl costOfLivingBillServiceImpl;

	@Autowired
	private PaymentStatusServiceImpl paymentStatusServiceImpl;

	@Autowired
	private ContractServiceImpl contractServiceImpl;

	@GetMapping("/getall30daysafter")
	public List<COLBill> getAll() {
		List<COLBill> list = new ArrayList<>();

		List<CostOfLivingBill> listBill = costOfLivingBillServiceImpl.getAllBillBefore30Days();
		if (listBill != null) {
			for (CostOfLivingBill c : listBill) {
				COLBill bill = new COLBill();
				bill.setColId(c.getColID());
				bill.setDateCollect(String.valueOf(c.getDateCollect()));
				bill.setPaymentStatusId(c.getPaymentStatusID());
				bill.setTotalExpense(c.getTotalExpense());
				bill.setContractId(c.getContractID());

				Contract contract = contractServiceImpl.getContractByContractID(c.getContractID());
				if (contract != null) {
					bill.setOwnerID(contract.getOwnerID());
					bill.setRenterId(contract.getRenterID());
					bill.setPlaceId(contract.getPlaceID());

				}
				List<PaymentStatus> listPay = paymentStatusServiceImpl.getAllPaymentStatus();
				for (PaymentStatus ps : listPay) {
					if (c.getPaymentStatusID() == ps.getPaymentStatusID()) {
						bill.setPaymentStatusName(ps.getPaymentStatusName());
					}
				}
				list.add(bill);

			}
		}

		return list;
	}

	@GetMapping("/getbillbyownterid")
	public List<COLBill> getAllByOwnerID(@RequestParam("ownerID") int ownerID) {
		List<COLBill> list = new ArrayList<>();

		List<Contract> listContract = contractServiceImpl.getAllContractByOwnerID(ownerID);

		if (listContract != null) {

			for (Contract contract : listContract) {
				CostOfLivingBill bill = costOfLivingBillServiceImpl
						.getAllBillBefore30DaysByContractID(contract.getContractID());
				if (bill != null) {
					COLBill c = new COLBill();
					c.setColId(bill.getColID());
					c.setContractId(contract.getContractID());
					c.setDateCollect(String.valueOf(bill.getDateCollect()));
					c.setOwnerID(contract.getOwnerID());
					c.setPaymentStatusId(bill.getPaymentStatusID());
					c.setPlaceId(contract.getPlaceID());
					c.setRenterId(contract.getRenterID());
					c.setTotalExpense(bill.getTotalExpense());
					List<PaymentStatus> listPay = paymentStatusServiceImpl.getAllPaymentStatus();
					for (PaymentStatus ps : listPay) {
						if (bill.getPaymentStatusID() == ps.getPaymentStatusID()) {
							c.setPaymentStatusName(ps.getPaymentStatusName());
						}
					}
					list.add(c);

				}
			}
		}

		return list;
	}

	@GetMapping("/getbillbyrenterid")
	public List<COLBill> getAllByRenterID(@RequestParam("renterID") int renterID) {
		List<COLBill> list = new ArrayList<>();

		List<Contract> listContract = contractServiceImpl.getAllContractByRenterID(renterID);

		if (listContract != null) {

			for (Contract contract : listContract) {
				CostOfLivingBill bill = costOfLivingBillServiceImpl
						.getAllBillBefore30DaysByContractID(contract.getContractID());
				if (bill != null) {
					COLBill c = new COLBill();
					c.setColId(bill.getColID());
					c.setContractId(contract.getContractID());
					c.setDateCollect(String.valueOf(bill.getDateCollect()));
					c.setOwnerID(contract.getOwnerID());
					c.setPaymentStatusId(bill.getPaymentStatusID());
					c.setPlaceId(contract.getPlaceID());
					c.setRenterId(contract.getRenterID());
					c.setTotalExpense(bill.getTotalExpense());
					List<PaymentStatus> listPay = paymentStatusServiceImpl.getAllPaymentStatus();
					for (PaymentStatus ps : listPay) {
						if (bill.getPaymentStatusID() == ps.getPaymentStatusID()) {
							c.setPaymentStatusName(ps.getPaymentStatusName());
						}
					}
					list.add(c);

				}
			}
		}

		return list;
	}

	@PostMapping("/changeStatusBill")
	public boolean changeStatusBill(@RequestParam("colID") int colID, @RequestParam("billStatusID") int billStatusID) {
		try {
			costOfLivingBillServiceImpl.changeStatus(billStatusID, colID);

		} catch (Exception e) {
			System.err.print("change err");
		}

		return true;
	}

}
