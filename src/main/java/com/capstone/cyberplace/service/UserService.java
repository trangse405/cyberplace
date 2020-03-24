package com.capstone.cyberplace.service;

import com.capstone.cyberplace.model.User;

public interface UserService {

	void register(User u);

	User findUserByUserName(String username);

	boolean checkLogin(String username, String password);

}
