package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/info")
	public String message() {
		return "hello hii";
	}
	
	@GetMapping("/message")
	public String info() {
		return "Hello i am developer..!!!";
	}

}
