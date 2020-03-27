package com.capstone.cyberplace.dto;

public class RegisterForm {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String confirmPasswrd;

	public RegisterForm() {
		// TODO Auto-generated constructor stub
	}

	public RegisterForm(String firstName, String lastName, String username, String password, String confirmPasswrd) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.confirmPasswrd = confirmPasswrd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPasswrd() {
		return confirmPasswrd;
	}

	public void setConfirmPasswrd(String confirmPasswrd) {
		this.confirmPasswrd = confirmPasswrd;
	}

}
