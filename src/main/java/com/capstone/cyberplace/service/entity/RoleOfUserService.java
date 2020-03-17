package com.capstone.cyberplace.service.entity;

import java.util.List;

import com.capstone.cyberplace.model.entity.RoleOfUser;



public interface RoleOfUserService {
	
	List<RoleOfUser> listRole();
	void insertRole(String role);
}
