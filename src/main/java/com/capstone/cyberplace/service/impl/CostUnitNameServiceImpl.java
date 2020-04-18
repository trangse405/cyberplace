package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.CostUnitName;
import com.capstone.cyberplace.repository.CostUnitNameRepository;
import com.capstone.cyberplace.service.CostUnitNameService;

@Service
@Transactional
public class CostUnitNameServiceImpl implements CostUnitNameService {

	@Autowired
	private CostUnitNameRepository costUnitNameRepository;

	@Override
	public List<CostUnitName> getAllListCostName() {
		// TODO Auto-generated method stub
		return costUnitNameRepository.getAllListCostName();
	}

}
