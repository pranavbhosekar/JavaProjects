package com.springrest.restapi.services;

import java.util.List;

import com.springrest.restapi.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
		
	public Course getCourse(long courseId);

	public Course addCourse(Course course);
}
