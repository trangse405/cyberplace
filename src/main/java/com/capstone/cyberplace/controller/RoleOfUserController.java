package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.RoleOfUser;
import com.capstone.cyberplace.service.impl.RoleOfUserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/role")
public class RoleOfUserController {
	
	@Autowired
	 private RoleOfUserServiceImpl roleOfUserServiceImpl;
	
	
	@GetMapping("/getall")
    public List<RoleOfUser> getAllStatistic() {
        return roleOfUserServiceImpl.listRole();
    }
	
	
	@PostMapping("/insert")
	public String insert(@RequestParam("role") String  role  ) {
		String mess ="ok";
		try {
			
			roleOfUserServiceImpl.insertRole(role);
			
		} catch (Exception e) {
			// TODO: handle exception
			mess= "fail";
		}

		
	return mess;
	}
	

}
