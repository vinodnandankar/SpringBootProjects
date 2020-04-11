package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DataSheet;
import com.example.demo.model.User;
import com.example.demo.service.UploadService;
import com.example.demo.service.UploadSheetService;

@RestController
public class UploadController {
	
	public final UploadService uploadService;
	public final UploadSheetService uploadSheetService;

	public UploadController(UploadService uploadService,UploadSheetService uploadSheetService) {
		this.uploadService=uploadService;
		this.uploadSheetService=uploadSheetService;

	}

	/*@PostMapping("/upload")
	public List<User> upload(@RequestParam("file")MultipartFile file) throws Exception {
		return uploadService.upload(file);
	}*/
	
	@PostMapping("/upload")
	public List<DataSheet> upload(@RequestParam("file")MultipartFile file) throws Exception {
//		return uploadService.upload(file);
		return uploadSheetService.upload(file);

	}
}
