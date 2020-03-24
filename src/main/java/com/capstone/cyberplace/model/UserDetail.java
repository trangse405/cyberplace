package com.capstone.cyberplace.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetail")
public class UserDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int userID;
	
	
	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "day_of_birth")
	private Date dayOfBirth;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "bank_account", nullable = false)
	private String bankAccount;

	@Column(name = "avatar_link", nullable = false)
	private String avatar_link;
	
	
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}


	public UserDetail(int userID, String name, String gender, Date dayOfBirth, String address, String phoneNumber,
			String email, String bankAccount, String avatar_link) {
		super();
		this.userID = userID;
		this.name = name;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.bankAccount = bankAccount;
		this.avatar_link = avatar_link;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDayOfBirth() {
		return dayOfBirth;
	}


	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}


	public String getAvatar_link() {
		return avatar_link;
	}


	public void setAvatar_link(String avatar_link) {
		this.avatar_link = avatar_link;
	}
	
	
	

}
