package com.imaeil.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class File {
	private static final Logger logger = LoggerFactory.getLogger(File.class);
	
	private String fileDir = "C:\\upload\\web\\tmp";
	private int maxFileSize = 20971520;
	private int maxRequestSize = 41943040;
	private int fileSizeThreshold = 20971520;
	private List<FileInfo> fileList;
	
	public File(String fileDir, int maxFileSize, int maxRequestSize, int fileSizeThreshold) {
		FileInit(fileDir, maxFileSize, maxRequestSize, fileSizeThreshold);
	}
	
	public File() {
		FileInit(this.fileDir, this.maxFileSize, this.maxRequestSize, this.fileSizeThreshold);
	}
	
	private void FileInit(String fileDir, int maxFileSize, int maxRequestSize, int fileSizeThreshold) {
		this.fileDir = fileDir;
		this.maxFileSize = maxFileSize;
		this.maxRequestSize = maxRequestSize;
		this.fileSizeThreshold = fileSizeThreshold;
	}
	
	public MultipartConfigElement getMultipartConfigElement() {
		return new MultipartConfigElement(fileDir, maxFileSize, maxRequestSize, fileSizeThreshold);
	}
	
	public void setMultipartFiles(MultipartFile[] multipartFiles) {
		this.fileList = new ArrayList<FileInfo>();
		
		for(MultipartFile multipartFile : multipartFiles) {
			FileInfo file = new FileInfo(multipartFile);
			fileList.add(file);
		}
	}
	
	public void saveFiles() {
		if(multipartFileIsEmpty()) return;
		
		for(FileInfo file : fileList) {
			file.saveFile(fileDir);
		}
	}
	
	public boolean multipartFileIsEmpty() {
		return fileList.isEmpty();
	}
	
	public List<FileInfo> fileInfo() {
		return fileInfo(false);
	}
	
	public List<FileInfo> fileInfo(boolean show) {
		if(!multipartFileIsEmpty() && show) {
			for(FileInfo file : fileList) {
				logger.info("------------------------------");
				logger.info("Upload File Name : " + file.getFileName());
				logger.info("Upload File ext : " + file.getExt());
				logger.info("Upload File Original : " + file.getOriginalFilename());
				logger.info("Upload File Size : " + file.getFileSize());
				logger.info("Upload File SaveResult : " + file.getSaveResult());
			}
		} else {
			logger.info("Upload File Empty");
		}
		
		return fileList;
	}
}
