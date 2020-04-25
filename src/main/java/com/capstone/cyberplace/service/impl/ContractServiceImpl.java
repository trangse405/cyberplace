package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.Contract;
import com.capstone.cyberplace.model.CostOfLivingBill;
import com.capstone.cyberplace.repository.ContractRepository;
import com.capstone.cyberplace.service.ContractService;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository contractRepository;

	@Override
	public void insertContract(int owner_id, int renter_id, int place_id, String start_date, String end_date, float fee,
			int contract_status_id, int orderID) {
		contractRepository.insertContract(owner_id, renter_id, place_id, start_date, end_date, fee, contract_status_id,
				orderID);

	}

	@Override
	public void changeStatusContractByContractID(int contractStatusID, int contractID) {
		contractRepository.changeStatusContractByContractID(contractStatusID, contractID);

	}

	@Override
	public List<Contract> getAllContract() {

		return contractRepository.getAllContract();
	}

	@Override
	public List<Contract> getAllContractByOwnerID(int owner_id) {

		return contractRepository.getAllContractByOwnerID(owner_id);
	}

	@Override
	public List<Contract> getAllContractByRenterID(int renterID) {

		return contractRepository.getAllContractByRenterID(renterID);
	}

	@Override
	public Contract getContractByContractID(int contractID) {

		return contractRepository.getContractByContractID(contractID);
	}



}
