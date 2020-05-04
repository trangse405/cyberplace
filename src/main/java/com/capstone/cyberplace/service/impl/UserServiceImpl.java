package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.User;
import com.capstone.cyberplace.repository.UserRepository;
import com.capstone.cyberplace.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(User u) {
		userRepository.register(u.getUserName(), u.getPassword(), u.getRoleID(), u.getStatusID());

	}

	@Override
	public User findUserByUserName(String username) {

		return userRepository.findUserByUserName(username);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		User u = userRepository.checkLogin(username, password);
		if (u != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllStaff() {

		return userRepository.getAllStaff();
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.getAllUser();
	}

	@Override
	public User getUserByUserID(int userID) {

		return userRepository.getUserByUserID(userID);
	}

	@Override
	public void changeStatus(int statusID, int userID) {
		userRepository.changeStatus(statusID, userID);

	}

}
