package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

	@Autowired
	private AppConfiguration configuration;

	@RequestMapping("/message")
	String getMessage() {
		return configuration.getMessage();
	}

}

// http://localhost:8080/message