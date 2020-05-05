package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.dto.form.InsertedUserDetailForm;
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
	public void insertNameToUserDetail(int userID, String name, String avatarLink) {
		userDetailRepository.insertNameToUserDetail(userID, name, avatarLink);

	}

	@Override
	public UserDetail getDetailByUserID(int userID) {

		return userDetailRepository.getDetailByUserID(userID);
	}

	@Override
	public void updateUserDetail(String name, String gender, String dayOfBirth, String address, String phoneNumber,
			String email, String bankAccount, String avatarLink, int userID) {
		userDetailRepository.updateUserDetail(name, gender, dayOfBirth, address, phoneNumber, email, bankAccount,
				avatarLink, userID);

	}

}
