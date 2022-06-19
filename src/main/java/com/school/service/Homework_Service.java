package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Homework;
import com.school.repo.Homework_Repo;

@Service
public class Homework_Service {

	@Autowired
	private Homework_Repo homework_Repo;
	
	public void add(Homework homework) {
		homework_Repo.save(homework);
	}
	public List<Homework> showAll(){
	return 	homework_Repo.findAll();
	}
}
