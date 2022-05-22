package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DoctorClientRestController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/doctor-client/{id}")
	public ResponseEntity<?> getDoctor(@PathVariable String id) {
		return restTemplate.getForEntity("http://doctor-service/" + id, String.class);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

// http://localhost:8084/doctor-client/1
