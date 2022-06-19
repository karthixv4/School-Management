package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Student;
import com.school.repo.Student_Repo;


@Service
public class Student_Service {

	@Autowired
	private Student_Repo student_Repo;
	
	public void addStudent(Student student) {
		student_Repo.save(student);
	}
	public List<Student> showAll(){
		return student_Repo.findAll();
	}
}
