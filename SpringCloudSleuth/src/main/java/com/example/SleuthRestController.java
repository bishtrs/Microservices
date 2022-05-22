package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SleuthRestController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/api") // http://localhost:8080/api
	public String hello() {
		LOG.info("Hello Sleuth");

		return restTemplate.getForObject("http://localhost:8082/api2", String.class);
	}

}
