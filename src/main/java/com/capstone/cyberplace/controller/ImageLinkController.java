package com.capstone.cyberplace.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.cyberplace.service.GoogleDriveApiService;
import com.capstone.cyberplace.service.impl.ImageLinkServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/imagelink")
public class ImageLinkController {
	
	@Autowired
	private ImageLinkServiceImpl imageLinkServiceImpl;
	
	@Autowired
	private GoogleDriveApiService googleDriveServiceImpl;
	
	
	@PostMapping("/upload")
	public boolean uploadImage(@RequestParam("file") MultipartFile[] file ,@RequestParam("placeid") int placeid ) throws IOException {
		
		for (MultipartFile f : file) {

			if (f.isEmpty()) {
				continue;
			} else {
				File fi = convertMultiPartToFile(f);
				com.google.api.services.drive.model.File file2 = googleDriveServiceImpl.uploadFileDirectl(fi.getName(),
						"image/jpg", fi);
				
				imageLinkServiceImpl.insertImageLink(placeid, file2.getWebViewLink());
				try {
					System.err.println(file2.toPrettyString());
				} catch (Exception e) {
					return false;
				}
			}

		}

		return true;
	}
	
	// ---------------------------
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
