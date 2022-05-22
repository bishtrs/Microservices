package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SleuthRestController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping(value = "/api2") // http://localhost:8080/api
	public String hello() {
		LOG.info("Hello Sleuth you have invoked second microservice");
		return "Hello Sleuth you have invoked second microservice";
	}

}
