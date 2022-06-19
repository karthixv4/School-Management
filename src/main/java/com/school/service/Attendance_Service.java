package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Attendance;
import com.school.repo.Attendance_Repo;

@Service
public class Attendance_Service {

	@Autowired
	private Attendance_Repo attendance_Repo;
	
	public void save(Attendance attendance) {
		attendance_Repo.save(attendance);
	}
}
