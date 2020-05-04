package com.capstone.cyberplace.service;

import com.capstone.cyberplace.dto.form.InsertedUserDetailForm;
import com.capstone.cyberplace.model.UserDetail;

public interface UserDetailService {

	void insertUserDetail(InsertedUserDetailForm form);

	void insertNameToUserDetail(int userID, String name);

	UserDetail getDetailByUserID(int userID);

	void updateUserDetail(String name, String gender, String dayOfBirth, String address, String phoneNumber,
			String email, String bankAccount, String avatarLink, int userID);
}
