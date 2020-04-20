package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.form.ChangeStatusCheckingForm;
import com.capstone.cyberplace.model.CheckingList;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.UserDetail;
import com.capstone.cyberplace.service.impl.CheckingListServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/checkinglist")
public class CheckingListController {

	@Autowired
	private CheckingListServiceImpl checkingListServiceImpl;

	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	public JavaMailSender emailSender;

	@PostMapping("/change-status-checking")
	public boolean changeStatusChecking(@Valid @RequestBody ChangeStatusCheckingForm form) {

		try {

			checkingListServiceImpl.updateStatusCheckingListItem(form.getStatusCheckingID(), form.getCheckingID());
			placeServiceImpl.changeStatusPlace(form.getStatusPlaceID(), form.getPlaceID());
			Place p = placeServiceImpl.getPlaceByPlaceID(form.getPlaceID());
			UserDetail user = userDetailServiceImpl.getDetailByUserID(p.getOwnerID());
			if (form.getStatusCheckingID() == 0) {
				sendEmailCancel(user.getEmail(), user.getName(), p.getTitle());
			}
			if (form.getCheckingID() == 1) {
				CheckingList c = checkingListServiceImpl.getCheckingByPlaceID(form.getPlaceID());
				sendEmailAccept(user.getEmail(), user.getName(), p.getTitle(), String.valueOf(c.getDateTime()),
						p.getContactPhoneNumber());
			}

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@GetMapping("/get-checking-list")
	public List<CheckingList> getAllCheckingListbyUserID(@RequestParam("userID") int userID) {
		List<Place> listP = new ArrayList<Place>();

		listP = placeServiceImpl.getListForManagePost(userID);
		List<CheckingList> listC = new ArrayList<CheckingList>();
		if (listP != null) {
			for (Place p : listP) {
				CheckingList c = new CheckingList();
				c = checkingListServiceImpl.getCheckingByPlaceID(p.getPlaceID());
				if (c != null) {
					listC.add(c);
				}

			}
		}

		return listC;
	}

	@GetMapping("/get-all-checking-list")
	public List<CheckingList> getAllCheckingList() {

		List<CheckingList> listC = checkingListServiceImpl.getAllCheckingList();

		return listC;
	}

	public void sendEmailCancel(String receiver, String userName, String title) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();
		boolean multipart = true;

		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
		String htmlMsg = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>" + "<meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
				+ "</head>\r\n" + "<body>\r\n" + "<div>\r\n" + "  <div>Xin chào <b>" + userName + " </b>,</div>\r\n"
				+ "<div><b><br></b></div>\r\n"
				+ "    &emsp;&emsp; Hệ thống <span class=\"badge badge-info\">CyberPlace</span> đã hủy bỏ tin :  <b>\" "
				+ title + "\"&nbsp;</b>\r\n" + "   \r\n" + "            <div> "
				+ ". Mọi thắc mắc xin vui lòng liên hệ qua email của chúng tôi.</div>\r\n" + "    <div><br></div>\r\n"
				+ "   <div>Xin cảm ơn bạn.</div>\r\n"
				+ "   <div>__________________________<br><b>CYBER PLACE&nbsp;</b></div><div><b>Address</b>: FPT University</div><div><b>Email</b>:&nbsp;cybermanager99@gmail.com</div>\r\n"
				+ "</div>" + "</body>\r\n" + "</html>";

		helper.setText(htmlMsg, true);
		helper.setTo(receiver);

		helper.setSubject("Hệ thống CyberPlace");

		this.emailSender.send(message);

	}

	public void sendEmailAccept(String receiver, String userName, String title, String datetime, String phoneNumber)
			throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();
		boolean multipart = true;
		// String endcode = "UTF-8";
		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
		String htmlMsg = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>" + "<meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
				+ "</head>\r\n" + "<body>\r\n" + "<div>\r\n" + "  <div>Xin chào <b>" + userName + " </b>,</div>\r\n"
				+ "<div><b><br></b></div>\r\n"
				+ "    &emsp;&emsp; Hệ thống <span class=\"badge badge-info\">CyberPlace</span> xác nhận bạn đã đăng tin <b>\" "
				+ title + "\"&nbsp;</b>\r\n" + "    <div>Thời gian kiểm tra nhà: <b>" + datetime + "</b></div>\r\n"
				+ "            <div>Chúng tôi sẽ liên lạc với bạn qua số điện thoại " + phoneNumber
				+ ". Xin vui lòng để ý cuộc gọi tới của bạn.</div>\r\n" + "    <div><br></div>\r\n"
				+ "   <div>Cảm ơn bạn.</div>\r\n"
				+ "   <div>__________________________<br><b>CYBER PLACE&nbsp;</b></div><div><b>Address</b>: FPT University</div><div><b>Email</b>:&nbsp;cybermanager99@gmail.com</div>\r\n"
				+ "</div>" + "</body>\r\n" + "</html>";

		// message.setContent(htmlMsg, "text/html");

		helper.setText(htmlMsg, true);
		// message.setText(htmlMsg, "UTF-8");
		helper.setTo(receiver);

		helper.setSubject("Thông báo duyệt tin đăng");

		this.emailSender.send(message);

	}

}
