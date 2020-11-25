package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.filHelper.FileUploadHelperr;

@RestController
public class FileUploader {
  
	
	@Autowired
	private FileUploadHelperr fl;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		try {
			
			if(file.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("please chose the correct file");
				
			}
			
			if(!file.getContentType().equals("image/jpeg"))
			{
				
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg content are allowed");
				
			}
			
			
			boolean f = fl.uploadFile(file);
			if(f)
			{
				
				//return ResponseEntity.ok("file uploaded");
				
				//or
				
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
			
		} catch (Exception e) {
			// TODO: handle exceptio
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("somethong went wrong please try after sometimes");
	}
	
}
