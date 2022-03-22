package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class AppConfiguration {

	@Value("${message:Hello default}")
	private String message;

	String getMessage() {
		return this.message;
	}

}

// curl -X POST http://localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"