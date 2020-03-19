package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.StreetDB;
import com.capstone.cyberplace.service.impl.StreetDBServiceImpl;

@RestController
@RequestMapping("/street")
public class StreetDBController {
	
	@Autowired
	private StreetDBServiceImpl streetDBServiceImpl;
	
	@GetMapping("/getallstreet")
    public List<StreetDB> getAllStreet() {
        return streetDBServiceImpl.getAllStreet();
    }

}
