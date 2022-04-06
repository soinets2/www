package com.imaeil.controller.file;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imaeil.util.File;
import com.imaeil.util.FileInfo;

@Controller
@RequestMapping("/file")
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		logger.info("uploadForm");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFiles, Model model) {
		logger.info("uploadFormAction");
		
		File file = new File();
		file.setMultipartFiles(uploadFiles);
		file.saveFiles();
		file.fileInfo();
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		logger.info("uploadAjax");
	}
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public ResponseEntity<List<FileInfo>> uploadAjaxAction(MultipartFile[] uploadFiles) {
		logger.info("uploadAjaxAction");
		
		File file = new File();
		file.setMultipartFiles(uploadFiles);
		file.saveFiles();
		
		return new ResponseEntity<>(file.fileInfo(true), HttpStatus.OK);
	}
}
