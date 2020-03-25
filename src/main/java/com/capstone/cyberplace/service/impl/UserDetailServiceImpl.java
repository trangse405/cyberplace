package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.dto.InsertedUserDetailForm;
import com.capstone.cyberplace.repository.UserDetailRepository;
import com.capstone.cyberplace.service.UserDetailService;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public void insertUserDetail(InsertedUserDetailForm form) {

		userDetailRepository.insertUserDetail(form.getUserID(), form.getName(), form.getGender(), form.getDayOfBirth(),
				form.getAddress(), form.getPhoneNumber(), form.getEmail(), form.getBankAccount(), form.getAvatarLink());
		;
	}

}
