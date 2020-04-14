package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.Contract;

public interface ContractService {

	void insertContract(int owner_id, int renter_id, int place_id, String start_date, String end_date, float fee,
			int contract_status_id);

	void changeStatusContractByContractID(int contractStatusID, int contractID);

	List<Contract> getAllContract();

	List<Contract> getAllContractByOwnerID(int owner_id);
}
