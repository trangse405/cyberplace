package com.capstone.cyberplace.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.UserLogin;
import com.capstone.cyberplace.model.User;
import com.capstone.cyberplace.service.impl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/register")
	public String insert(@RequestParam("uname") String uname, @RequestParam("upass") String upass) {
		String mess = "Insert Success";

		User user = checkUserName(uname);
		if (user != null) {
			return " User Name has exist! " + bcryptPassword(upass);
			
		}

		try {
			User u = new User();
			u.setUserName(uname);
			u.setPassword(bcryptPassword(upass));
			u.setRoleID(CommonConstant.RoleID_User);
			u.setStatusID(CommonConstant.User_Status_ID_Active);
			userServiceImpl.register(u);
		} catch (Exception e) {
			mess = "Something wrong!";
		}
		return mess;
	}

	@PostMapping("/login")
	public UserLogin login(@RequestParam("uname") String uname, @RequestParam("upass") String upass) {

		User user = checkUserName(uname);
		if (user == null) {
			return new UserLogin(null, " Wrong user name! ");
		}
		boolean checkpass = checkPassword(upass, user.getPassword());
		if (checkpass == false) {
			return new UserLogin(null, " Wrong password!  ");
		}

		return new UserLogin(user, " Login Success ");
	}

	// BCrypt password format

	public String bcryptPassword(String password) {

		String inserted_pass = BCrypt.hashpw(password, BCrypt.gensalt(CommonConstant.Number_Loop_BCrypt));

		return inserted_pass;
	}

	// check input password
	public boolean checkPassword(String InputPassword, String password) {

		boolean checker = BCrypt.checkpw(InputPassword, password);

		return checker;
	}

	// check username
	public User checkUserName(String username) {

		User u = userServiceImpl.findUserByUserName(username);

		return u;
	}

	public boolean checkLogin(String username, String password) {

		return true;
	}

}
