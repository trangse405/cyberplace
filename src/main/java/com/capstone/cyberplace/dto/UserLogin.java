package com.capstone.cyberplace.dto;

import com.capstone.cyberplace.model.User;
import com.capstone.cyberplace.model.UserDetail;

public class UserLogin {

	private User u;
	private UserDetail ud;

	private String message;

	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	

	public UserLogin(User u, UserDetail ud, String message) {
		super();
		this.u = u;
		this.ud = ud;
		this.message = message;
	}



	public UserDetail getUd() {
		return ud;
	}



	public void setUd(UserDetail ud) {
		this.ud = ud;
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
