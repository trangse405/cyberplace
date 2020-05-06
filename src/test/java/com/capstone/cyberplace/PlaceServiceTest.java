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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.capstone.cyberplace.controller.PlaceController;
import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(PlaceController.class)
public class PlaceServiceTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PlaceServiceImpl serviceImpl;

	@Test
	public void testGetTop6() throws Exception {

		List<Place> listTop6 = new ArrayList<Place>();

		Place p1 = new Place(1, 1, "Place1", 100000, 11, 1, 1, 1, "Address1", 1, 1, 1, 11, "Đông", 1, 1, 1, "Mô tả 1",
				"place1.jpg", "chủ 1", "111111", "địa chỉ 1 ", "email 1", "11-11-2011");

		listTop6.add(p1);
		given(serviceImpl.getTop6()).willReturn(listTop6);

		mvc.perform(get("/api/cp/places/top6").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].title", is("Place1"))).andExpect(jsonPath("$[0].address", is("Address1")))
				.andExpect(jsonPath("$[0].price", is(100000))).andExpect(jsonPath("$[0].ownerID", is(1)))
				.andExpect(jsonPath("$[0].area", is(1)));

	}
	
	
	
}
