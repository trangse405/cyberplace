package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.RoleOfPlace;
import com.capstone.cyberplace.service.impl.RoleOfPlaceServiceImpl;

@RestController
@RequestMapping("/roleofplace")
public class RoleOfPlaceController {
	
	@Autowired
	private RoleOfPlaceServiceImpl roleOfPlaceServiceImpl;
	
	
	@GetMapping("/getallrole")
    public List<RoleOfPlace> getAllRole() {
		
        return roleOfPlaceServiceImpl.getAllRole();
    }

}
