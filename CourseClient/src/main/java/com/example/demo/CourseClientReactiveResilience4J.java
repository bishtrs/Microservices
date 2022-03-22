package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class CourseClientReactiveResilience4J {

	private static final Logger LOG = LoggerFactory.getLogger(CourseClientReactiveResilience4J.class);
	private final WebClient webClient;
	private final ReactiveCircuitBreaker reactiveCircuitBreaker;

	public CourseClientReactiveResilience4J(ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory,
			RestTemplate restTemplate) {
		this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
		this.reactiveCircuitBreaker = circuitBreakerFactory.create("courses");
	}

	public Mono<String> courseList() {
		return reactiveCircuitBreaker.run(webClient.get().uri("/courses").retrieve().bodyToMono(String.class),
				throwable -> {
					LOG.error("error while calling course service", throwable);
					return Mono.just("{id:1, description: Computer Science}");
				});
	}

}