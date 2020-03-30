package com.capstone.cyberplace.dto.form;

public class InsertedUserDetailForm {

	private int userID;
	private String name;
	private String gender;
	private String dayOfBirth;
	private String address;
	private String phoneNumber;
	private String email;
	private String bankAccount;
	private String avatarLink;

	public InsertedUserDetailForm() {
		// TODO Auto-generated constructor stub
	}

	public InsertedUserDetailForm(int userID, String name, String gender, String dayOfBirth, String address,
			String phoneNumber, String email, String bankAccount, String avatarLink) {
		super();
		this.userID = userID;
		this.name = name;
		this.gender = gender;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.bankAccount = bankAccount;
		this.avatarLink = avatarLink;
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

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
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

	public String getAvatarLink() {
		return avatarLink;
	}

	public void setAvatarLink(String avatarLink) {
		this.avatarLink = avatarLink;
	}

}
