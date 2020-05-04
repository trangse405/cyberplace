package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.StatusOfUser;
import com.capstone.cyberplace.repository.StatusOfUserRepository;
import com.capstone.cyberplace.service.StatusOfUserService;

@Service
@Transactional
public class StatusOfUserServiceImpl implements StatusOfUserService {

	@Autowired
	private StatusOfUserRepository statusOfUserRepository;

	@Override
	public List<StatusOfUser> getAllStatus() {

		return statusOfUserRepository.getAllStatus();
	}

}
