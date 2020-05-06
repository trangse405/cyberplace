package com.capstone.cyberplace.controller;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.common.CommonConstant;
import com.capstone.cyberplace.dto.UserLogin;
import com.capstone.cyberplace.dto.form.RegisterForm;
import com.capstone.cyberplace.dto.form.ValidEmailFrom;
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

	@Autowired
	public JavaMailSender emailSender;

	private String default_avatar_link = "https://lh3.googleusercontent.com/proxy/CQjK6vpWjzvnVeCc6CxMy7-aldYB8a0-TEjlX4bSFisLyFKh8abqP4u5WKkIl3vvalLCJ6MK4CcjQrPwOFesoHyEVQM3zvEm72l9yiVx1l6efbIKwXALOnaeQIpy?fbclid=IwAR1ELm3kkx3NyU9C_sd75u6xf9xPNFyt72cbNA_YrPjhpY8J4B6eD5344Ic";

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

			userDetailServiceImpl.insertNameToUserDetail(uID, form.getLastName() + form.getFirstName(),
					default_avatar_link);

		} catch (Exception e) {
			System.out.print(e);
		}
		return true;
	}

	@PostMapping("/send-valid-code")
	public ValidEmailFrom validCode(@RequestParam("email") String email) throws MessagingException {

		ValidEmailFrom form = new ValidEmailFrom();
		form.setEmail(email);
		String code = randomAlphaNumeric(8);
		form.setValidCode(code);
		sendEmail(email, code);

		return form;
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

	// -------------------------
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
	private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
	private static final String digits = "0123456789";
	private static Random generator = new Random();

	public static int randomNumber(int min, int max) {
		return generator.nextInt((max - min) + 1) + min;
	}

	private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

	public String randomAlphaNumeric(int numberOfCharactor) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfCharactor; i++) {
			int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
			char ch = ALPHA_NUMERIC.charAt(number);
			sb.append(ch);
		}
		return sb.toString();
	}

	// send email
	public void sendEmail(String receiver, String code) throws MessagingException {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(receiver);
		message.setSubject("Gửi mã xác thực");
		message.setText("Hệ thống gửi bạn mã xác thực : " + code);

		// Send Message!
		this.emailSender.send(message);
	}

}
