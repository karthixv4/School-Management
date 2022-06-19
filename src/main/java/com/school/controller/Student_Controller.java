package com.school.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.school.model.Role;
import com.school.model.Student;
import com.school.model.Users;
import com.school.repo.RoleRepo;
import com.school.repo.UserRepo;
import com.school.service.Classroom_Service;
import com.school.service.Student_Service;

@Controller
public class Student_Controller {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 

	@Autowired
	private Student_Service student_Service;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired Classroom_Service classroom_Service;
	
	@GetMapping("/addStudent")
	public String addstudent(Model model) {
		model.addAttribute("Student",new Student());
		model.addAttribute("Classroom",classroom_Service.showAll());
		return "addStudent";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid Student student,Model model,final @RequestParam("file") MultipartFile file) throws IOException  {
		String fileName = file.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		

		// Save the file locally
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(file.getBytes());
		stream.close();

		
		student.setFileName(fileName);
		student.setFilePath(filePath);
		student.setFileType(fileType);
		
		
		Users user = new Users();
		String email = student.getEmail();
    	
    	if(userRepo.findByEmail(email) != null) {
    		model.addAttribute("exist","An account already exists with this Email please Login");
    		return "redirect:/register";
    		
    	} else {
    		user.setEmail(email);
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	    String encodedPassword = passwordEncoder.encode(student.getPassword());
    	    user.setPassword(encodedPassword);
    	    Role userRole= roleRepo.findByName("student");
    		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    	    userRepo.save(user);
    	    student_Service.addStudent(student);
       
    	}
		
		
		
		return "";
	}
	@GetMapping("/studentsList")
	public String students(Model model) {
		List<Student> student = student_Service.showAll();
		model.addAttribute("Student",student);
		return "students";
	}
	
}
