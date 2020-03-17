package com.capstone.cyberplace.controller.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.entity.AreaDB;
import com.capstone.cyberplace.service.impl.AreaDBServiceImpl;

@RestController
@RequestMapping("/areadb")
public class AreaDBController {

	@Autowired
	private AreaDBServiceImpl areaDBServiceImpl;

	@PostMapping("/insert")
	public String insert(@RequestParam("district") String district) {
		String mess = "ok";
		try {
			areaDBServiceImpl.insertArea(district);

		} catch (Exception e) {
			// TODO: handle exception
			mess = "fail";
		}

		return mess;
	}
	
	@GetMapping("/getall")
    public List<AreaDB> getAllStatistic() {
		
        return areaDBServiceImpl.listArea();
    }
	

}
