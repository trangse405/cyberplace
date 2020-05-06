package com.capstone.cyberplace;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.service.impl.StreetDBServiceImpl;

public class StreetDBServiceTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StreetDBServiceImpl serviceImpl;

	@Test
	public void getAllStreet() throws Exception {

		List<StreetDB> listStreet = new ArrayList<>();

		StreetDB street = new StreetDB(1, 1, "Street1");

		listStreet.add(street);
		given(serviceImpl.getAllStreet()).willReturn(listStreet);

		mvc.perform(get("/street/getallstreet").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].districtID", is(1))).andExpect(jsonPath("$[0].streetName", is("Street1")));

	}
}
