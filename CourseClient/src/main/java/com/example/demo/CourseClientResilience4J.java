package com.example.demo;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseClientResilience4J {

	private static final Logger LOG = LoggerFactory.getLogger(CourseClientResilience4J.class);
	private final RestTemplate restTemplate;
	private final Resilience4JCircuitBreaker circuitBreaker;

	public CourseClientResilience4J(Resilience4JCircuitBreakerFactory circuitBreakerFactory,
			RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.circuitBreaker = circuitBreakerFactory.create("courses");
	}

	public String courseList() {
		URI uri = URI.create("http://localhost:8090/courses");
		return circuitBreaker.run(() -> this.restTemplate.getForObject(uri, String.class), throwable -> {
			LOG.error("error while calling course service", throwable);
			return "{id:1, description: Computer Science}";
		});
	}

}