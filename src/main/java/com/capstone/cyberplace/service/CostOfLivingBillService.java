package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.CostOfLivingBill;

public interface CostOfLivingBillService {

	void insertCostOfLivingBill(int contractID, String dateCollect, float totalExpense, int paymentStatusID);

	List<CostOfLivingBill> getAllBillBefore30Days();

	List<CostOfLivingBill> getAllBillBeforeEndMonth(int number);

	List<CostOfLivingBill> getAllBillBefore30DaysByContractID(int contractID);

	List<CostOfLivingBill> getAllBillByContractID(int contractID);

	void updateTotal(float totalExpense, int coliD);

	CostOfLivingBill getBillByColID(int colID);

	void changeStatus(int paymentStatusId, int colID);

	void updateCashPaidLinkByColID(String cashPaidLink, int colID);
}
