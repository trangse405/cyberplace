package com.capstone.cyberplace.controller;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.RegisterForm;
import com.capstone.cyberplace.dto.UserLogin;
import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.model.User;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;
import com.capstone.cyberplace.service.impl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@PostMapping("/register")
	public boolean insert(@RequestBody RegisterForm form) {

		User user = checkUserName(form.getUsername());
		if (user != null) {
			return false;

		}

		try {
			User u = new User();
			u.setUserName(form.getUsername());
			u.setPassword(bcryptPassword(form.getPassword()));
			u.setRoleID(CommonConstant.RoleID_User);
			u.setStatusID(CommonConstant.User_Status_ID_Active);
			userServiceImpl.register(u);

			int uID = getUserID(form.getUsername());

			userDetailServiceImpl.insertNameToUserDetail(uID, form.getLastName() + form.getFirstName());

		} catch (Exception e) {
			System.out.print(e);
		}
		return true;
	}

	@PostMapping("/login")
	public UserLogin login(@RequestParam("uname") String uname, @RequestParam("upass") String upass) {

		User user = checkUserName(uname);
		if (user == null) {
			return new UserLogin(null, null, "401");
		}
		boolean checkpass = checkPassword(upass, user.getPassword());
		if (checkpass == false) {
			return new UserLogin(null, null, "401");
		}
		if (user.getStatusID() == 0) {
			return new UserLogin(null, null, "401");
		}

		return new UserLogin(user, userDetailServiceImpl.getDetailByUserID(user.getUserID()), "200");
	}

	@GetMapping("/getallstaff")
	public List<User> getAllStaff() {
		return userServiceImpl.getAllStaff();
	}

	@GetMapping("/getalluser")
	public List<User> getAllUser() {
		return userServiceImpl.getAllUser();
	}

	/////////////////////// ------------------------logic---------------------------////////////////
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

	public int getUserID(String username) {

		User u = userServiceImpl.findUserByUserName(username);

		return u.getUserID();

	}

}
