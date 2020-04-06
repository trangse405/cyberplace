package com.capstone.cyberplace.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private static String UPLOAD_DIR = System.getProperty("user.home") + "/image";;

	@Autowired
	private ImageLinkServiceImpl imageLinkServiceImpl;

	@Autowired
	private GoogleDriveApiService googleDriveServiceImpl;

//	@PostMapping("/upload")
//	public String uploadImage(@RequestParam("file") MultipartFile[] file) throws IOException {
//
//		String link = "";
//		for (MultipartFile f : file) {
//
//			if (f.isEmpty()) {
//				continue;
//			} else {
//				File fi = convertMultiPartToFile(f);
//				com.google.api.services.drive.model.File file2 = googleDriveServiceImpl.uploadFileDirectl(fi.getName(),
//						"image/jpg", fi);
//				
//				
//
//				// imageLinkServiceImpl.insertImageLink( file2.getWebViewLink());
//				link = file2.getWebViewLink();
//				try {
//					System.err.println(file2.toPrettyString());
//				} catch (Exception e) {
//					return "";
//				}
//			}
//
//		}
//
//		return link;
//	}

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFileMulti(@RequestParam("file") MultipartFile[] file) throws Exception {

		System.out.print(UPLOAD_DIR);
		for (MultipartFile f : file) {

			if (f.isEmpty()) {
				continue;
			}

		}

		String result = null;
		try {

			result = this.saveUploadedFiles(file);

		}
		// Here Catch IOException only.
		// Other Exceptions catch by RestGlobalExceptionHandler class.
		catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		String[] s = result.split(",");
		return new ResponseEntity<String>(s[0], HttpStatus.OK);
	}

	// Save Files
	private String saveUploadedFiles(MultipartFile[] files) throws IOException {

		// Make sure directory exists!
		File uploadDir = new File(UPLOAD_DIR);
		uploadDir.mkdirs();

		StringBuilder sb = new StringBuilder();

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue;
			}
			String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();

			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFilePath);
			Files.write(path, bytes);

			sb.append(uploadFilePath).append(", ");
		}
		return sb.toString();
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
