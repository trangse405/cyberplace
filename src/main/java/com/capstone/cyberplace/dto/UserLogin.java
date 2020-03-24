package com.capstone.cyberplace.dto;

import com.capstone.cyberplace.model.User;

public class UserLogin {

	private User u;

	private String message;

	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	public UserLogin(User u, String message) {
		super();
		this.u = u;
		this.message = message;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
