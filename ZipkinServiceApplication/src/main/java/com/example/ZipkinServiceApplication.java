package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;


@EnableZipkinServer
@SpringBootApplication
public class ZipkinServiceApplication {

	// http://localhost:9411
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceApplication.class, args);
	}

}
