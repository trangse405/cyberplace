package com.capstone.cyberplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.entity.User;
import com.capstone.cyberplace.repository.entity.UserRepository;
import com.capstone.cyberplace.service.entity.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(User u) {
		userRepository.register(u.getUserName(), u.getPassword(), u.getRoleID(), u.getStatusID(), u.getEmail());
		
	}
	
	
	

}
