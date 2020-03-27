package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.dto.InsertedUserDetailForm;
import com.capstone.cyberplace.model.UserDetail;
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

	@Override
	public void insertNameToUserDetail(int userID, String name) {
		userDetailRepository.insertNameToUserDetail(userID, name);

	}

	@Override
	public UserDetail getDetailByUserID(int userID) {

		return userDetailRepository.getDetailByUserID(userID);
	}

}
