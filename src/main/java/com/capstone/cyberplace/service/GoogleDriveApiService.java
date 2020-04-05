package com.capstone.cyberplace.service;

import com.google.api.services.drive.model.File;

public interface GoogleDriveApiService {

	public File uploadFile(String fileName , String filePath , String mimeType);
	
	public File uploadFileDirectl(String fileName ,  String mimeType , java.io.File f);


}
