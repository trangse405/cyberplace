package com.capstone.cyberplace.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.dto.WardData;
import com.capstone.cyberplace.model.WardDB;
import com.capstone.cyberplace.service.impl.WardDBServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/warddb")
public class WardDBController {

	@Autowired
	private WardDBServiceImpl wardDBServiceImpl;

	@GetMapping("/getAll")
	public List<WardDB> getAllWard() {

		return wardDBServiceImpl.listAllWard();
	}

	@GetMapping("/getallwardbydistrict")
	public List<WardData> getAllWardByDistrict(@RequestParam("districtid") int districtID) {

		List<WardDB> list = wardDBServiceImpl.getAllWardByDistrictID(districtID);
		List<WardData> listData = new ArrayList<>();

		for (WardDB w : list) {
			WardData item = new WardData(w.getId(), w.getWard_name());
			listData.add(item);

		}
		return listData;
	}

}
