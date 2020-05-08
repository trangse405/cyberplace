package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.CostOfLivingBill;
import com.capstone.cyberplace.repository.CostOfLivingBillRepository;
import com.capstone.cyberplace.service.CostOfLivingBillService;

@Service
@Transactional
public class CostOfLivingBillServiceImpl implements CostOfLivingBillService {

	@Autowired
	private CostOfLivingBillRepository costOfLivingBillRepository;

	@Override
	public void insertCostOfLivingBill(int contractID, String dateCollect, float totalExpense, int paymentStatusID) {
		costOfLivingBillRepository.insertCostOfLivingBill(contractID, dateCollect, totalExpense, paymentStatusID);

	}

	@Override
	public List<CostOfLivingBill> getAllBillBefore30Days() {

		return costOfLivingBillRepository.getAllBillBefore30Days();
	}

	@Override
	public List<CostOfLivingBill> getAllBillBefore30DaysByContractID(int contractID) {

		return costOfLivingBillRepository.getAllBillBefore30DaysByContractID(contractID);
	}

	@Override
	public List<CostOfLivingBill> getAllBillByContractID(int contractID) {

		return costOfLivingBillRepository.getAllBillByContractID(contractID);
	}

	@Override
	public void updateTotal(float totalExpense, int coliD) {
		costOfLivingBillRepository.updateTotal(totalExpense, coliD);

	}

	@Override
	public CostOfLivingBill getBillByColID(int colID) {

		return costOfLivingBillRepository.getBillByColID(colID);
	}

	@Override
	public void changeStatus(int paymentStatusId, int colID) {
		costOfLivingBillRepository.changeStatus(paymentStatusId, colID);

	}

	@Override
	public void updateCashPaidLinkByColID(String cashPaidLink, int colID) {
		costOfLivingBillRepository.updateCashPaidLinkByColID(cashPaidLink, colID);

	}

	@Override
	public List<CostOfLivingBill> getAllBillBeforeEndMonth(int number) {

		return costOfLivingBillRepository.getAllBillBeforeEndMonth(number);
	}

	@Override
	public List<CostOfLivingBill> getAllBillBeforeEndMonthByContractID(int number, int contractID) {

		return costOfLivingBillRepository.getAllBillBeforeEndMonthByContractID(number, contractID);
	}

}
