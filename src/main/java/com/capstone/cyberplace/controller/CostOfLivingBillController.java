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
import com.capstone.cyberplace.dto.COLBillDetail;
import com.capstone.cyberplace.model.Contract;
import com.capstone.cyberplace.model.CostOfLivingBill;
import com.capstone.cyberplace.model.CostOfLivingBillDetail;
import com.capstone.cyberplace.model.CostOfPlace;
import com.capstone.cyberplace.model.CostUnitName;
import com.capstone.cyberplace.model.PaymentStatus;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.service.impl.ContractServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillDetailServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.CostUnitNameServiceImpl;
import com.capstone.cyberplace.service.impl.PaymentStatusServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/costofliving")
public class CostOfLivingBillController {

	@Autowired
	private CostOfLivingBillServiceImpl costOfLivingBillServiceImpl;
	@Autowired
	private CostOfPlaceServiceImpl costOfPlaceServiceImpl;

	@Autowired
	private PaymentStatusServiceImpl paymentStatusServiceImpl;

	@Autowired
	private ContractServiceImpl contractServiceImpl;

	@Autowired
	private CostUnitNameServiceImpl costUnitNameServiceImpl;

	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	@Autowired
	private CostOfLivingBillDetailServiceImpl costOfLivingBillDetailServiceImpl;

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

				Place p = placeServiceImpl.getPlaceByPlaceID(contract.getPlaceID());
				bill.setPlacePrice(p.getPrice());
				bill.setColBillDetails(getDetail(c.getColID()));
				list.add(bill);

			}
		}

		return list;
	}

	@GetMapping("/getbillbycolid")
	public COLBill getBillByCOLID(@RequestParam("colID") int colID) {

		CostOfLivingBill c = costOfLivingBillServiceImpl.getBillByColID(colID);
		if (c != null) {

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

				Place p = placeServiceImpl.getPlaceByPlaceID(contract.getPlaceID());
				bill.setPlacePrice(p.getPrice());
				bill.setColBillDetails(getDetail(c.getColID()));
				return bill;
			}
		}

		return null;
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
					Place p = placeServiceImpl.getPlaceByPlaceID(contract.getPlaceID());
					c.setPlacePrice(p.getPrice());
					c.setColBillDetails(getDetail(bill.getColID()));
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
					Place p = placeServiceImpl.getPlaceByPlaceID(contract.getPlaceID());
					c.setPlacePrice(p.getPrice());
					c.setColBillDetails(getDetail(bill.getColID()));
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

	private List<COLBillDetail> getDetail(int colID) {
		List<COLBillDetail> list = new ArrayList<>();

		List<CostOfLivingBillDetail> listDetail = costOfLivingBillDetailServiceImpl.getBillDetailByColID(colID);
		int placeID = 0;
		if (listDetail != null) {
			for (CostOfLivingBillDetail detail : listDetail) {
				COLBillDetail bd = new COLBillDetail();
				bd.setAmount(detail.getAmount());
				bd.setColId(detail.getColID());
				bd.setCostId(detail.getCostOfPlaceID());
				CostOfPlace c = costOfPlaceServiceImpl.getCostOfPlaceByID(detail.getCostOfPlaceID());
				placeID = c.getPlaceID();
				bd.setCostPrice(c.getCostPrice());
				bd.setExpensePerCost(detail.getExpensePerCost());
				bd.setCostName(c.getCostName());
				List<CostUnitName> listUnitName = costUnitNameServiceImpl.getAllListCostName();
				for (CostUnitName unit : listUnitName) {
					if (c.getUnitID() == unit.getId()) {
						bd.setUnitName(unit.getUnitName());
					}
				}
				list.add(bd);

			}
		}

		List<CostOfPlace> listCost = costOfPlaceServiceImpl.getListCostByPlaceID(placeID);
		for (CostOfPlace cost : listCost) {
			if (cost.getUnitID() == 2) {
				COLBillDetail c = new COLBillDetail();
				c.setAmount(1);
				c.setColId(colID);
				c.setCostId(cost.getId());
				c.setCostPrice(cost.getCostPrice());

				List<CostUnitName> listUnitName = costUnitNameServiceImpl.getAllListCostName();
				for (CostUnitName unit : listUnitName) {
					if (cost.getUnitID() == unit.getId()) {
						c.setUnitName(unit.getUnitName());
						c.setUnitID(unit.getId());
					}
				}
				c.setCostName(cost.getCostName());
				c.setExpensePerCost(cost.getCostPrice());
				list.add(c);

			}
		}
		return list;
	}

}
