package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.CostOfLivingBillDetail;

public interface CostOfLivingBillDetailService {

	List<CostOfLivingBillDetail> getBillDetailByColID(int colID);

	void insertCostOfLivingBillDetail(int colID, int cost_of_place_id, float expensePerCost, float amount);

	void updateBillDetail(float amount, int col_id, int cost_of_place_id);
}
