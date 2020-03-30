package com.capstone.cyberplace.service;

import java.util.List;

import com.capstone.cyberplace.model.ImageLink;

public interface ImageLinkService {
	
	List<ImageLink> getListImageByPlaceID(int placeID);
	
	void insertImageLink(int place_id, String image_link);

}
