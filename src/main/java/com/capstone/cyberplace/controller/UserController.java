package com.capstone.cyberplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.model.User;
import com.capstone.cyberplace.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	
	
	@PostMapping("/register")
	public String insert(@RequestParam("uname") String uname, @RequestParam("upass") String upass,
			@RequestParam("email") String email) {
		String mess = "ok";
		try {
			User u = new User();
			u.setUserName(uname);
			u.setPassword(upass);
			u.setRoleID(CommonConstant.RoleID_User);
			u.setStatusID(CommonConstant.User_Status_ID_Active);
			u.setEmail(email);

			userServiceImpl.register(u);

		} catch (Exception e) {
			// TODO: handle exception
			mess = "fail";
		}
		return mess;
	}
}
