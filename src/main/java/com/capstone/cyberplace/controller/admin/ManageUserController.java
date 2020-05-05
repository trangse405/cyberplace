package com.capstone.cyberplace.controller.admin;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.AdminManageUserForm;
import com.capstone.cyberplace.model.RoleOfUser;
import com.capstone.cyberplace.model.StatusOfUser;
import com.capstone.cyberplace.model.User;
import com.capstone.cyberplace.model.UserDetail;
import com.capstone.cyberplace.service.impl.RoleOfUserServiceImpl;
import com.capstone.cyberplace.service.impl.StatusOfUserServiceImpl;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;
import com.capstone.cyberplace.service.impl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/manageuser")
public class ManageUserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private RoleOfUserServiceImpl roleOfUserServiceImpl;
	@Autowired
	private StatusOfUserServiceImpl statusOfUserServiceImpl;

	@GetMapping("/get-all-user")
	public List<AdminManageUserForm> getAllUser() {

		List<AdminManageUserForm> list = new ArrayList<>();
		List<User> listUser = userServiceImpl.getAllUser();
		List<RoleOfUser> listRole = roleOfUserServiceImpl.listRole();
		List<StatusOfUser> listStatus = statusOfUserServiceImpl.getAllStatus();
		if (listUser != null) {
			for (User u : listUser) {
				AdminManageUserForm userForm = new AdminManageUserForm();
				userForm.setUserID(u.getUserID());
				userForm.setUserName(u.getUserName());
				userForm.setStatusID(u.getStatusID());
				for (RoleOfUser role : listRole) {
					if (u.getRoleID() == role.getRoleID()) {
						userForm.setRoleName(role.getRoleName());
					}
				}
				for (StatusOfUser status : listStatus) {
					if (u.getStatusID() == status.getStatusID()) {
						userForm.setStatusName(status.getStatus());
					}
				}
				UserDetail detail = userDetailServiceImpl.getDetailByUserID(u.getUserID());
				if (detail != null) {
					userForm.setName(detail.getName());
					userForm.setGender(detail.getGender());
					userForm.setDob(String.valueOf(detail.getDayOfBirth()));
					userForm.setAddress(detail.getAddress());
					userForm.setPhoneNumber(detail.getPhoneNumber());
					userForm.setEmail(detail.getEmail());
					userForm.setBankAccount(detail.getBankAccount());
					userForm.setAvatarLink(detail.getAvatar_link());

				}
				list.add(userForm);

			}
		}

		return list;
	}

	@GetMapping("/get-user-by-id")
	public AdminManageUserForm getUserByUserID(@RequestParam("userID") int userID) {

		User u = userServiceImpl.getUserByUserID(userID);
		List<RoleOfUser> listRole = roleOfUserServiceImpl.listRole();
		List<StatusOfUser> listStatus = statusOfUserServiceImpl.getAllStatus();
		if (u != null) {

			AdminManageUserForm userForm = new AdminManageUserForm();
			userForm.setUserID(u.getUserID());
			userForm.setUserName(u.getUserName());
			userForm.setStatusID(u.getStatusID());
			for (RoleOfUser role : listRole) {
				if (u.getRoleID() == role.getRoleID()) {
					userForm.setRoleName(role.getRoleName());

				}
				for (StatusOfUser status : listStatus) {
					if (u.getStatusID() == status.getStatusID()) {
						userForm.setStatusName(status.getStatus());
					}
				}
				UserDetail detail = userDetailServiceImpl.getDetailByUserID(u.getUserID());
				if (detail != null) {
					userForm.setName(detail.getName());
					userForm.setGender(detail.getGender());
					userForm.setDob(String.valueOf(detail.getDayOfBirth()));
					userForm.setAddress(detail.getAddress());
					userForm.setPhoneNumber(detail.getPhoneNumber());
					userForm.setEmail(detail.getEmail());
					userForm.setBankAccount(detail.getBankAccount());
					userForm.setAvatarLink(detail.getAvatar_link());

				}
				return userForm;

			}
		}

		return null;
	}

	@PostMapping("/update-user")
	public boolean updateUser(@Valid @RequestBody AdminManageUserForm form) {

		if (form != null) {
		
			userDetailServiceImpl.updateUserDetail(form.getName(), form.getGender(), form.getDob(), form.getAddress(),
					form.getPhoneNumber(), form.getEmail(), form.getBankAccount(), form.getAvatarLink(),
					form.getUserID());

			return true;

		}

		return false;
	}

	@PostMapping("/change-status")
	public boolean changeStatus(@RequestParam("statusID") int statusID, @RequestParam("userID") int userID) {

		try {
			userServiceImpl.changeStatus(statusID, userID);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
