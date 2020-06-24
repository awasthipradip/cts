package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.CourseDao;
import com.cts.dto.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courserepo;

	public Course addCourse(Course course) {
		return courserepo.save(course);
	}

	public List<Course> addCourses(List<Course> courses) {
		return courserepo.saveAll(courses);
	}

	public List<Course> retrieveAllCourses() {
		return courserepo.findAll();
	}

	public Course retrieveCourse(int courseId) {
		return courserepo.findById(courseId).orElse(null);
	}

	public String removeCourse(int courseId) {
		courserepo.deleteById(courseId);
		return "Course details removed of id:" + courseId;
	}
}
