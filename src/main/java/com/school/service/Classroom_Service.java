package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Classroom;
import com.school.repo.Classroom_Repo;

@Service
public class Classroom_Service {

	@Autowired
	private Classroom_Repo classroom_Repo;
	
	public void addClassroom(Classroom classroom) {
		classroom_Repo.save(classroom);
	}
	public<Classroom>List showAll(){
		return classroom_Repo.findAll();
	}

}
