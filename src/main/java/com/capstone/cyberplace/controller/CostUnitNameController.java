package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.CostUnitName;
import com.capstone.cyberplace.service.impl.CostUnitNameServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/costunitname")
public class CostUnitNameController {

	@Autowired
	private CostUnitNameServiceImpl costUnitNameServiceImpl;

	@GetMapping("/getAllCostUnitName")
	public List<CostUnitName> getAll() {

		return costUnitNameServiceImpl.getAllListCostName();
	}

}
