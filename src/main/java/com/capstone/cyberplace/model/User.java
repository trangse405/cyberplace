package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int userID;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role_id", nullable = false)
	private int roleID;

	@Column(name = "status_id", nullable = false)
	private int statusID;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String userName, String password, int roleID, int statusID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.roleID = roleID;
		this.statusID = statusID;
	}
	
	
	
	

	public User(String userName, String password, int roleID, int statusID) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleID = roleID;
		this.statusID = statusID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

}
