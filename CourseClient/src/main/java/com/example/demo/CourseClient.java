package com.example.demo;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CourseClient {

	private static final Logger LOG = LoggerFactory.getLogger(CourseClient.class);
	private final RestTemplate restTemplate;
	private final CircuitBreaker readingListCircuitBreaker;

	public CourseClient(CircuitBreakerFactory circuitBreakerFactory, RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.readingListCircuitBreaker = circuitBreakerFactory.create("courses");
	}

	public String courseList() {
		URI uri = URI.create("http://localhost:8090/courses");
		return readingListCircuitBreaker.run(() -> this.restTemplate.getForObject(uri, String.class), throwable -> {
			LOG.error("error while calling course service", throwable);
			return "{id:1, description: Computer Science}";
		});
	}

}