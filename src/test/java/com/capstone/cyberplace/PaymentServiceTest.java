package com.capstone.cyberplace;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capstone.cyberplace.model.Payment;
import com.capstone.cyberplace.service.impl.PaymentServiceImpl;

public class PaymentServiceTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PaymentServiceImpl serviceImpl;

	@Test
	public void getPaymet() throws Exception {

		Payment p = new Payment(1, 1, 1, "2020-01-01", "1", "PAYERID1", 50, "PayPal", "1");

		mvc.perform(get("/payment/getallpayment").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].userID", is(1))).andExpect(jsonPath("$[0].createTime", is("2020-01-01")));

	}
}
