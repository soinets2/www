package com.imaeil.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileInfo {
	private static final Logger logger = LoggerFactory.getLogger(FileInfo.class);
	
	private String fileName;
	private String ext;
	private MultipartFile multipartFile;
	private boolean saveResult;
	
	public FileInfo(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
		this.fileName = Utils.getUUID();
		this.ext = Utils.getSplitExt(multipartFile.getOriginalFilename());
		this.saveResult = false;
	}
	
	public void saveFile(String fileDir) {
		File file = new File(fileDir, getFullName());
		
		try {
			multipartFile.transferTo(file);
			setSaveResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			setSaveResult(false);
		}
	}
	
	public String getFullName() {
		return fileName + "." + ext;
	}
	
	public boolean getMultipartFileIsEmpty() {
		return multipartFile.isEmpty();
	}
	
	public boolean getSaveResult() {
		return saveResult;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getExt() {
		return ext;
	}
	
	public String getOriginalFilename() {
		return multipartFile.getOriginalFilename();
	}
	
	public long getFileSize() {
		return multipartFile.getSize();
	}
	
	private void setSaveResult(boolean saveResult) {
		this.saveResult = saveResult;
	}
}
