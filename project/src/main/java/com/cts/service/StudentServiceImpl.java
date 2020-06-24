package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.StudentDao;
import com.cts.dto.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studrepo;

	public Student addStudent(Student student) {
		return studrepo.save(student);
	}

	public List<Student> addStudents(List<Student> students) {
		return studrepo.saveAll(students);
	}

	public List<Student> retrieveAllStudents() {
		return studrepo.findAll();
	}

	public Student retrieveStudent(int studentId) {
		return studrepo.findById(studentId).orElse(null);
	}

	public String removeStudent(int studentId) {
		studrepo.deleteById(studentId);
		return "Student details removed of id:" + studentId;
	}

}
