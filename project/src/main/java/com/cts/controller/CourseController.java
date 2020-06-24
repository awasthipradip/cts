package com.cts.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.Course;
import com.cts.service.CourseService;

@RestController
@RequestMapping(path = "/course")
public class CourseController {

	@Autowired
	private CourseService courseservice;
	
	@GetMapping(path = "/test")
	public String test() {
		return "HII";
	}

	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return courseservice.addCourse(course);
	}

	@PostMapping("/addCourses")
	public List<Course> addCourses(@RequestBody List<Course> courses) {
		return courseservice.addCourses(courses);
	}

	@GetMapping("/getCourse/{courseId}")
	public ResponseEntity<Course> retrieveCourse(@PathVariable int courseId) {
		try {
			Course c = courseservice.retrieveCourse(courseId);
			return new ResponseEntity<Course>(c, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getCourses")
	public List<Course> retrieveAllCourses() {
		return courseservice.retrieveAllCourses();
	}

	@DeleteMapping("/deleteCourse/{courseId}")
	public String removeCourse(@PathVariable int courseId) {
		return courseservice.removeCourse(courseId);
	}
}
