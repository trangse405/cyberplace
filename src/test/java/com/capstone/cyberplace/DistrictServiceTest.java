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

import com.capstone.cyberplace.controller.DistrictDBController;
import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(DistrictDBController.class)
public class DistrictServiceTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DistrictDBServiceImpl serviceImpl;
	
	
	@Test
	public void getAllDistrict() throws Exception {

		List<DistrictDB> listDistrict = new ArrayList<>();

		DistrictDB district = new DistrictDB(1,"District1","111","111","type1");

		listDistrict.add(district);
		given(serviceImpl.listArea()).willReturn(listDistrict);

		mvc.perform(get("/districtdb/getalldistrict").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].district_name", is("District1"))).andExpect(jsonPath("$[0].district_latitude", is("111")))
				.andExpect(jsonPath("$[0].district_longitude", is("111"))).andExpect(jsonPath("$[0].district_type", is("type1")));
			

	}
	

}
