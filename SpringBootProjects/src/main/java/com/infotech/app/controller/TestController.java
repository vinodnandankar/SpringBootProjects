package com.infotech.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public String getText() {
		return "-------------------------Hello Vinod Nandankar--------------------------";
		
	}

}
