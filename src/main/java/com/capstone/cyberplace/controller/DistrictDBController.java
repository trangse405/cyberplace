package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.DistrictDB;
import com.capstone.cyberplace.service.impl.DistrictDBServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")	
@RestController
@RequestMapping("/districtdb")
public class DistrictDBController {

	@Autowired
	private DistrictDBServiceImpl districtDBServiceImpl;

	@PostMapping("/insert")
	public String insert(@RequestParam("district") String district) {
		String mess = "ok";
		try {
			districtDBServiceImpl.insertArea(district);

		} catch (Exception e) {
			// TODO: handle exception
			mess = "fail";
		}

		return mess;
	}
	
	@GetMapping("/getall")
    public List<DistrictDB> getAllDistrict() {
		
		
        return districtDBServiceImpl.listArea();
    }
	

}
