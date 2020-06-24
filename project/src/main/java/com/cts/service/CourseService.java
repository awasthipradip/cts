package com.cts.service;

import java.util.List;

import com.cts.dto.Course;

public interface CourseService {
	
	public Course addCourse(Course course);
	public List<Course> addCourses(List<Course> courses);
	public List<Course> retrieveAllCourses();
	public Course retrieveCourse(int courseId);
	public String removeCourse(int courseId);

}
