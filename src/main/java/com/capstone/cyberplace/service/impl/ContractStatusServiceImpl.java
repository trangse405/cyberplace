package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.ContractStatus;
import com.capstone.cyberplace.repository.ContractStatusRepository;
import com.capstone.cyberplace.service.ContractStatusService;

@Service
@Transactional
public class ContractStatusServiceImpl implements ContractStatusService {

	@Autowired
	private ContractStatusRepository contractStatusRepository;

	@Override
	public List<ContractStatus> getAllContractStatus() {

		return contractStatusRepository.getAllContractStatus();
	}

}
