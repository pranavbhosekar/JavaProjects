package com.springrest.restapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//import org.springframework.boot.autoconfigure.cache.CouchbaseCacheManagerBuilderCustomizer;


import com.springrest.restapi.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {

	
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(125, "Java Core", "Basic Java"));
		list.add(new Course(655, "Spring Boot", "Basic Spring Boot"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course : list) {
			if(course.getId()==courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	

	

}
