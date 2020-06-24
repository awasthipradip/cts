package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.dto.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
