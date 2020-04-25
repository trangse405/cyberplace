package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.PaymentStatus;
import com.capstone.cyberplace.repository.PaymentStatusRepository;
import com.capstone.cyberplace.service.PaymentStatusService;

@Service
@Transactional
public class PaymentStatusServiceImpl implements PaymentStatusService {

	@Autowired
	private PaymentStatusRepository repository;

	@Override
	public List<PaymentStatus> getAllPaymentStatus() {
		// TODO Auto-generated method stub
		return repository.getAllPaymentStatus();
	}

}
