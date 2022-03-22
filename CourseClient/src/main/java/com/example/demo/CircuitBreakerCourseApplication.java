package com.example.demo;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@SpringBootApplication
public class CircuitBreakerCourseApplication {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	// Default Configuration for Resilience4JCircuitBreakerFactory
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build());
	}
	
	// Default Configuration for ReactiveResilience4JCircuitBreakerFactory
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultReactiveCustomizer() {
	    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
	            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
	            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build());
	}

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerCourseApplication.class, args);
	}

}