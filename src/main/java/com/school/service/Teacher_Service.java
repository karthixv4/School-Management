package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Teacher;
import com.school.repo.Teacher_Repo;

@Service
public class Teacher_Service {
	
	@Autowired
	private Teacher_Repo teacher_Repo;
	
	public void addTeacher(Teacher teacher) {
		teacher_Repo.save(teacher);
	}
	public <Teacher>List showAll(){
		return teacher_Repo.findAll();
	}

}
