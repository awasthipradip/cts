package com.cts.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@GeneratedValue
	@Column(name = "COURSE_ID")
	private int courseId;

	@Column(name = "COURSE_NAME", nullable = false, length = 100)
	private String name;

	@Column(name = "COURSE_DESCRIPTION", nullable = false, length = 100)
	private String description;

	public Course(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course() {
	}
}