package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.entity.RoleOfUser;
import com.capstone.cyberplace.repository.entity.RoleOfUserRepository;
import com.capstone.cyberplace.service.entity.RoleOfUserService;



@Service
@Transactional
public class RoleOfUserServiceImpl implements RoleOfUserService{

	@Autowired
	private RoleOfUserRepository roleOfUserRepository;

	@Override
	public List<RoleOfUser> listRole() {
		List<RoleOfUser> list = roleOfUserRepository.getall();
		return list;
	}

	@Override
	public void insertRole(String role) {		
		roleOfUserRepository.insertRole(role);
	}

	
}
