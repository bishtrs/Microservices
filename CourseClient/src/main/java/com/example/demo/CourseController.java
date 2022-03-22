package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class CourseController {
	
	@Autowired
	private CourseClientResilience4J courseClient;
	@Autowired
	private CourseClientReactiveResilience4J reactiveCourseClient;

	
	@RequestMapping("/allCourses") // http://localhost:8080/allCourses
	public String getCourseList() {
		return courseClient.courseList();
	}
	
	@RequestMapping("/allCoursesReactive") // http://localhost:8080/allCoursesReactive
	public Mono<String> getCourseListReactive() {
		return reactiveCourseClient.courseList();
	}
	

}
