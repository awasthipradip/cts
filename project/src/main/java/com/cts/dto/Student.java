package com.cts.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	private int studentid;

	@Column(name="STUDENT_NAME")
	private String name;
	
	@Column(name="STUDENT_DESCRIPTION")
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
	@JoinColumn(name = "COURSE_ID") })
	private List<Course> course;
	
	public Student(String name, String description, List<Course> course) {
		super();
		this.name = name;
		this.description=description;
		this.course = course;
		
	}
	
	public Student() {
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
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
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

}
