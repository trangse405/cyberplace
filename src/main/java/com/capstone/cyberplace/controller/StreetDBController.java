package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.service.impl.StreetDBServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/street")
public class StreetDBController {

	@Autowired
	private StreetDBServiceImpl streetDBServiceImpl;

	@GetMapping("/getallstreet")
	public List<StreetDB> getAllStreet() {
		return streetDBServiceImpl.getAllStreet();
	}

	@GetMapping("/getstreetbydistrict")
	public List<StreetDB> getAllStreetByWardID(@RequestParam("districtid") int districtID) {

		List<StreetDB> list = streetDBServiceImpl.getAllStreetByDistrictID(districtID);
//		List<StreetData> listData = new ArrayList<>();
//		for (StreetDB s : list) {
//			StreetData item = new StreetData(s.getId(), s.getStreetName());
//			listData.add(item);
//		}

		return list;
	}

}
