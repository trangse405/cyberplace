package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.RoleOfUser;



public interface RoleOfUserService {
	
	List<RoleOfUser> listRole();
	void insertRole(String role);
}
