package com.springrest.restapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.restapi.entities.Course;
import com.springrest.restapi.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService cService;
//	@GetMapping("/home")
//	public String home() {
//		return "Welcome";
//	}
	//get courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.cService.getCourses();
		
	}
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.cService.getCourse(Long.parseLong(courseId));
	}
	@PostMapping(path = "/courses", consumes ="application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.cService.addCourse(course);
	}
}
