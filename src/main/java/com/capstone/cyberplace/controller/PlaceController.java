package com.capstone.cyberplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cyberplace.model.Place;
import com.capstone.cyberplace.service.impl.PlaceServiceImpl;

@RestController
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	private PlaceServiceImpl placeServiceImpl;
	
	
	@GetMapping("/top6")
    public List<Place> getAllStatistic() {
		
        return placeServiceImpl.getTop6();
    }

}
