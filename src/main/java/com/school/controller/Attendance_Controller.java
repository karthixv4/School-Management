package com.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.model.Attendance;
import com.school.model.Student;
import com.school.repo.Student_Repo;
import com.school.service.Attendance_Service;

@Controller
public class Attendance_Controller {

	@Autowired
	private Attendance_Service attendance_Service;
	
	@Autowired
	private Student_Repo student_Repo;
	
	@GetMapping("/markAttendance/{id}")
	public String show(Model model,@PathVariable("id") Long id) {
		List<Student> student = student_Repo.findStudentById(id);
		model.addAttribute("Student",student);
		model.addAttribute("Attendance",new Attendance());
		
		return "markAttendance";
	}
	@PostMapping("/saveAttendance")
	public String save(@Valid Attendance attendance) {
		attendance_Service.save(attendance);
		
		return "";
	}
}
