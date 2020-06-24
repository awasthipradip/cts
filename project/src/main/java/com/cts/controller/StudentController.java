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

import com.cts.dto.Student;
import com.cts.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studservice;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studservice.addStudent(student);
	}

	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studservice.addStudents(students);
	}

	@GetMapping("/getStudent/{studentId}")
	public ResponseEntity<String> retrieveStudent(@PathVariable int studentId) {
		try {
			studservice.retrieveStudent(studentId);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Student not found", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getStudents")
	public List<Student> retrieveAllStudents() {
		return studservice.retrieveAllStudents();
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<String> removeStudent(@PathVariable int studentId) {
		try {
			studservice.removeStudent(studentId);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Student not found", HttpStatus.NOT_FOUND);
		}

	}
}
