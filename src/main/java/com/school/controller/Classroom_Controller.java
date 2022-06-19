package com.school.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.model.Classroom;
import com.school.model.Student;
import com.school.repo.Student_Repo;
import com.school.service.Classroom_Service;

@Controller
public class Classroom_Controller {

	@Autowired
	private Classroom_Service classroom_Service;
	
	@Autowired
	private Student_Repo student_Repo;
	
	@GetMapping("/addClassroom")
	public String addClassroom(Model model) {
		model.addAttribute("Classroom",new Classroom());
		return "addClassroom";
	}
	@PostMapping("/saveClassroom")
	public String saveClassroom(@Valid Classroom classroom) {
		
		classroom_Service.addClassroom(classroom);
		return "";
	}
	@GetMapping("/classroom/{id}")
	public String classroom(Model model,@PathVariable("id") Long id) {
		List<Student> student = student_Repo.findStudentById(id);
		System.out.println(student);
		model.addAttribute("Student",student);
		model.addAttribute("Classroom",id);
		return "students";
	}
}
