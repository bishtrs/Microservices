package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class CourseClientReactive {

	private static final Logger LOG = LoggerFactory.getLogger(CourseClientReactive.class);
	private final WebClient webClient;
	private final ReactiveCircuitBreaker circuitBreaker;
	
	public CourseClientReactive(ReactiveCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
        this.circuitBreaker = circuitBreakerFactory.create("courses");
      }


	public Mono<String> courseList() {
		return circuitBreaker.run(webClient.get().uri("/courses").retrieve().bodyToMono(String.class),
				throwable -> {
					LOG.error("error while calling course service", throwable);
					return Mono.just("{id:1, description: Computer Science}");
				});
	}

}