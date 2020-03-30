package com.capstone.cyberplace.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.InsertedUserDetailForm;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/userdetail")
public class UserDetailController {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@PostMapping("/insert-detail")
	public String insertUserDetail(@Valid @RequestBody InsertedUserDetailForm form) {
		String mess = "Insert Success";

		try {
			userDetailServiceImpl.insertUserDetail(form);
		} catch (Exception e) {
			mess = "Something wrong!";
		}
		return mess;
	}

}
