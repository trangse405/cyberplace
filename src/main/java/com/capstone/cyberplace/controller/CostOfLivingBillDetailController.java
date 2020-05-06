package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.COLBillDetail;
import com.capstone.cyberplace.dto.COLBillUpdate;
import com.capstone.cyberplace.model.Contract;
import com.capstone.cyberplace.model.CostOfLivingBill;
import com.capstone.cyberplace.model.CostOfLivingBillDetail;
import com.capstone.cyberplace.model.CostOfPlace;
import com.capstone.cyberplace.model.CostUnitName;
import com.capstone.cyberplace.service.impl.ContractServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillDetailServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfLivingBillServiceImpl;
import com.capstone.cyberplace.service.impl.CostOfPlaceServiceImpl;
import com.capstone.cyberplace.service.impl.CostUnitNameServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/costofliving")
public class CostOfLivingBillDetailController {

	@Autowired
	private CostOfLivingBillDetailServiceImpl costOfLivingBillDetailServiceImpl;

	@Autowired
	private CostOfPlaceServiceImpl costOfPlaceServiceImpl;
	@Autowired
	private CostOfLivingBillServiceImpl costOfLivingBillServiceImpl;

	@Autowired
	private CostUnitNameServiceImpl costUnitNameServiceImpl;
	@Autowired
	private ContractServiceImpl contractServiceImpl;

	
	/*
	 * api to get bill detail by col id
	 */
	@GetMapping("/getdetailbycolid")
	public List<COLBillDetail> getAll(@RequestParam("colID") int colID) {
		List<COLBillDetail> list = new ArrayList<>();

		List<CostOfLivingBillDetail> listDetail = costOfLivingBillDetailServiceImpl.getBillDetailByColID(colID);
		CostOfLivingBill bill = costOfLivingBillServiceImpl.getBillByColID(colID);
		Contract contract = contractServiceImpl.getContractByContractID(bill.getContractID());

		if (listDetail != null) {
			for (CostOfLivingBillDetail detail : listDetail) {
				COLBillDetail bd = new COLBillDetail();
				bd.setAmount(detail.getAmount());
				bd.setColId(detail.getColID());
				bd.setCostId(detail.getCostOfPlaceID());
				CostOfPlace c = costOfPlaceServiceImpl.getCostOfPlaceByID(detail.getCostOfPlaceID());

				bd.setCostPrice(c.getCostPrice());
				bd.setExpensePerCost(detail.getExpensePerCost());
				bd.setCostName(c.getCostName());
				List<CostUnitName> listUnitName = costUnitNameServiceImpl.getAllListCostName();
				for (CostUnitName unit : listUnitName) {
					if (c.getUnitID() == unit.getId()) {
						bd.setUnitName(unit.getUnitName());
						bd.setUnitID(unit.getId());
					}
				}
				list.add(bd);

			}
		}

		List<CostOfPlace> listCost = costOfPlaceServiceImpl.getListCostByPlaceID(contract.getPlaceID());
		if (listCost != null) {
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
		}

		return list;
	}
	/*
	 * api to update bill detail
	 */
	@PostMapping("/updatebilldetail")
	public boolean updateBill(@Valid @RequestBody COLBillUpdate form) {

		if (form != null) {
			int colID = 0;
			List<COLBillDetail> listDetail = form.getColBillDetails();
			for (COLBillDetail detail : listDetail) {
				colID = detail.getColId();
				if (detail.getUnitID() == 1) {

					costOfLivingBillDetailServiceImpl.updateBillDetail(detail.getAmount(), detail.getExpensePerCost(),
							detail.getColId(), detail.getCostId());
				}
			}
			costOfLivingBillServiceImpl.updateTotal(form.getTotalExpense(), colID);
			return true;

		}

//		if (form != null) {
//			for (UpdateBillForm detail : form) {
//				if (detail.getUnitID() == 1) {
//					CostOfLivingBillDetail costDetail = costOfLivingBillDetailServiceImpl
//							.getDetailByColIDAndCostOfPlaceID(detail.getColId(), detail.getCostId());
//					if (costDetail.getAmount() == 0) {
//						try {
//
//							CostOfPlace cost = costOfPlaceServiceImpl.getCostOfPlaceByID(detail.getCostId());
//							if (cost != null) {
//								float expense_per_cost = detail.getAmount() * cost.getCostPrice();
//								costOfLivingBillDetailServiceImpl.updateBillDetail(detail.getAmount(), expense_per_cost,
//										detail.getColId(), detail.getCostId());
//								CostOfLivingBill bill = costOfLivingBillServiceImpl.getBillByColID(detail.getColId());
//								// float total = detail.getAmount() * cost.getCostPrice() +
//								// bill.getTotalExpense();
//								try {
//									costOfLivingBillServiceImpl.updateTotal(detail.getTotalExpense(),
//											detail.getColId());
//								} catch (Exception e) {
//									System.out.print("update bill err");
//									return false;
//								}
//
//							}
//						} catch (Exception e) {
//							System.out.print("update detail err");
//							return false;
//						}
//					} else {
//
//						try {
//
//							CostOfPlace cost = costOfPlaceServiceImpl.getCostOfPlaceByID(detail.getCostId());
//							if (cost != null) {
//								float expense_per_cost = detail.getAmount() * cost.getCostPrice();
//								costOfLivingBillDetailServiceImpl.updateBillDetail(detail.getAmount(), expense_per_cost,
//										detail.getColId(), detail.getCostId());
//								CostOfLivingBill bill = costOfLivingBillServiceImpl.getBillByColID(detail.getColId());
//								// float total = detail.getAmount() * cost.getCostPrice() +
//								// bill.getTotalExpense()
//								// - costDetail.getAmount() * cost.getCostPrice();
//								try {
//									costOfLivingBillServiceImpl.updateTotal(detail.getTotalExpense(),
//											detail.getColId());
//								} catch (Exception e) {
//									System.out.print("update bill err");
//									return false;
//								}
//
//							}
//						} catch (Exception e) {
//							System.out.print("update detail err");
//							return false;
//						}
//
//					}
//				}
//
//			}
//		}
		return false;
	}

}
