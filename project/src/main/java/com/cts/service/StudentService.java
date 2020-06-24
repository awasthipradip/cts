package com.cts.service;

import java.util.List;

import com.cts.dto.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public List<Student> addStudents(List<Student> students);

	public List<Student> retrieveAllStudents();

	public Student retrieveStudent(int studentId);

	public String removeStudent(int studentId);
}
