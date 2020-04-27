package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.CostOfLivingBillDetail;
import com.capstone.cyberplace.repository.CostOfLivingBillDetailRepository;
import com.capstone.cyberplace.service.CostOfLivingBillDetailService;

@Service
@Transactional
public class CostOfLivingBillDetailServiceImpl implements CostOfLivingBillDetailService {

	@Autowired
	private CostOfLivingBillDetailRepository repository;

	@Override
	public List<CostOfLivingBillDetail> getBillDetailByColID(int colID) {
		return repository.getBillDetailByColID(colID);
	}

	@Override
	public void insertCostOfLivingBillDetail(int colID, int cost_of_place_id, float expensePerCost, float amount) {
		repository.insertCostOfLivingBillDetail(colID, cost_of_place_id, expensePerCost, amount);

	}

	@Override
	public void updateBillDetail(float amount, float expense_per_cost, int col_id, int cost_of_place_id) {
		repository.updateBillDetail(amount, expense_per_cost, col_id, cost_of_place_id);

	}

	@Override
	public CostOfLivingBillDetail getDetailByColIDAndCostOfPlaceID(int colID, int cost_of_place_id) {

		return repository.getDetailByColIDAndCostOfPlaceID(colID, cost_of_place_id);
	}

}
