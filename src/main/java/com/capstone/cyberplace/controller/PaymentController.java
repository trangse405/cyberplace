package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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

import com.capstone.cyberplace.model.Payment;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.model.UserDetail;
import com.capstone.cyberplace.service.impl.PaymentServiceImpl;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;
import com.capstone.cyberplace.service.impl.UserDetailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	@Autowired
	private PlaceServiceImpl placeServiceImpl;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	public JavaMailSender emailSender;

	/*
	 * insert payment information to database
	 */
	@PostMapping("/insert-payment")
	public boolean insertPaymentInfo(@RequestBody Payment paymentInfo) {

		boolean checkPayment = false;
		try {
			paymentServiceImpl.insertPaymentInfo(paymentInfo.getUserID(), paymentInfo.getPlaceID(),
					paymentInfo.getCreateTime(), paymentInfo.getStatus(), paymentInfo.getPayerID(),
					paymentInfo.getMoney(), paymentInfo.getDescription(), paymentInfo.getOrderID());
			checkPayment = true;
			sendEmailConfirm(paymentInfo);
		} catch (Exception e) {
			return false;
		}
		if (checkPayment == true) {
			// placeServiceImpl.changeStatusPlace(CommonConstant.Place_Status_ID_Deposited,
			// paymentInfo.getPlaceID());
		}

		return true;
	}

	/*
	 * get all payment
	 */
	@GetMapping("/getallpayment")
	public List<Payment> getAllPayment() {

		List<Payment> list = new ArrayList<>();

		try {
			list = paymentServiceImpl.getAllPayment();
		} catch (Exception e) {
			System.err.println("get all payment err");
		}

		return list;
	}

	/*
	 * get payment by userid
	 */
	@GetMapping("/getpaymentbyuserid")
	public List<Payment> getPaymentByUserID(@RequestParam("userID") int userID) {

		List<Payment> list = new ArrayList<>();

		try {
			list = paymentServiceImpl.getPaymentByUserID(userID);
		} catch (Exception e) {
			System.err.println("get  payment by userid  err");
		}

		return list;
	}

	/*
	 * function to send a accept email
	 */
	public void sendEmailConfirm(Payment p) throws MessagingException {
		UserDetail u = userDetailServiceImpl.getDetailByUserID(p.getUserID());
		Place place = placeServiceImpl.getPlaceByPlaceID(p.getPlaceID());
		MimeMessage message = emailSender.createMimeMessage();
		boolean multipart = true;
		// String endcode = "UTF-8";
		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
		String htmlMsg = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>" + "<meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
				+ "</head>\r\n" + "<body>\r\n" + "<div>\r\n" + "  <div>Xin chào <b>" + u.getName() + " </b>,</div>\r\n"
				+ "<div><b><br></b></div>\r\n"
				+ "    &emsp;&emsp; Hệ thống <span class=\"badge badge-info\">CyberPlace</span>xác nhận bạn đặt cọc nhà <b>\" "
				+ place.getTitle() + "\"&nbsp;</b>\r\n"
				+ "            <div>Chúng tôi sẽ liên lạc với bạn qua số điện thoại " + u.getPhoneNumber()
				+ ". Xin vui lòng để ý cuộc gọi tới của bạn.</div>\r\n" + "    <div><br></div>\r\n"
				+ "   <div>Cảm ơn bạn.</div>\r\n"
				+ "   <div>__________________________<br><b>CYBER PLACE&nbsp;</b></div><div><b>Address</b>: FPT University</div><div><b>Email</b>:&nbsp;cybermanager99@gmail.com</div>\r\n"
				+ "</div>" + "</body>\r\n" + "</html>";

		// message.setContent(htmlMsg, "text/html");

		helper.setText(htmlMsg, true);
		// message.setText(htmlMsg, "UTF-8");
		helper.setTo(u.getEmail());

		helper.setSubject("Thông báo đóng tiền cọc thành công");

		this.emailSender.send(message);

	}

}
