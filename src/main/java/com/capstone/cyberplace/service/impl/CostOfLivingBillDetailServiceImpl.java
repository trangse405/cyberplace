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
		// TODO Auto-generated method stub
		return repository.getBillDetailByColID(colID);
	}

	@Override
	public void insertCostOfLivingBillDetail(int colID, int cost_of_place_id, float expensePerCost, float amount) {
		repository.insertCostOfLivingBillDetail(colID, cost_of_place_id, expensePerCost, amount);

	}

	@Override
	public void updateBillDetail(float amount, int col_id, int cost_of_place_id) {
		repository.updateBillDetail(amount, col_id, cost_of_place_id);

	}

}