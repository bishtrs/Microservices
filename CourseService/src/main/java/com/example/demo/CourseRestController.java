package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestController {

	private static final Logger LOG = LoggerFactory.getLogger(CourseRestController.class);

	List<Course> courses = new ArrayList<>();

	public CourseRestController() {
		courses.add(new Course(1, "Computer Science"));
		courses.add(new Course(2, "Mathematics"));
		courses.add(new Course(3, "Physics"));
	}

	@RequestMapping(value = "/courses") // http://localhost:8090/courses
	public List<Course> listAll() {
		LOG.info("returning list of courses");
		return courses;
	}
/*
	@RequestMapping(value = "/recommended")
	public Mono<String> readingList() {
		return Mono.just("Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)");
	}*/

}
