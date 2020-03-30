package com.capstone.cyberplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.cyberplace.model.ImageLink;
import com.capstone.cyberplace.repository.ImageLinkRepository;
import com.capstone.cyberplace.service.ImageLinkService;

@Service
@Transactional
public class ImageLinkServiceImpl implements ImageLinkService {

	@Autowired
	private ImageLinkRepository imageLinkRepository;

	@Override
	public List<ImageLink> getListImageByPlaceID(int placeID) {

		return imageLinkRepository.getListImageByPlaceID(placeID);
	}

	@Override
	public void insertImageLink(int place_id, String image_link) {
		imageLinkRepository.insertImageLink(place_id, image_link);

	}

}
