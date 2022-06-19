package com.school.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.model.Homework;
import com.school.model.Teacher;
import com.school.repo.Teacher_Repo;
import com.school.service.Homework_Service;

@Controller
public class Homework_Controller {

	@Autowired
	private Homework_Service homework_Service;
	
	@Autowired 
	private Teacher_Repo teacher_Repo;
	
	@GetMapping("/addHomework")
	public String add(Model model,Principal principal) {
		String email = principal.getName();
		List<Teacher> teacher = teacher_Repo.findTeacherByEmail(email);
		model.addAttribute("Teacher",teacher);
		
		model.addAttribute("Homework",new Homework());
		
		return "addHomework";
	}
	@PostMapping("/saveHomework")
	public String save(@Valid Homework homework) {
		homework_Service.add(homework);
		return "/TeacherPanel";
	}
}
