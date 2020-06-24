package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.dto.Student;


public interface StudentDao extends JpaRepository<Student, Integer>{
	
}
