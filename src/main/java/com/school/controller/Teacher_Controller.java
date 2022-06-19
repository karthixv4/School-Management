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
import com.school.model.Teacher;
import com.school.model.Users;
import com.school.repo.RoleRepo;
import com.school.repo.UserRepo;
import com.school.service.Classroom_Service;
import com.school.service.Teacher_Service;



@Controller
public class Teacher_Controller {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 

	@Autowired
	private Teacher_Service teacher_Service;
	
	@Autowired
	private Classroom_Service classroom_Service;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@GetMapping("/addTeacher")
	public String addTeacher(Model model) {
		model.addAttribute("Teacher",new Teacher());
		return "addTeacher";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@Valid Teacher teacher,Model model,final @RequestParam("file") MultipartFile file) throws IOException  {
		String fileName = file.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		

		// Save the file locally
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(file.getBytes());
		stream.close();
		

		
		teacher.setFileName(fileName);
		teacher.setFilePath(filePath);
		teacher.setFileType(fileType);
		
		
		Users user = new Users();
		String email = teacher.getEmail();
    	
    	if(userRepo.findByEmail(email) != null) {
    		
    		model.addAttribute("exist","An account already exists with this Email please Login");
    	
    		return "redirect:/addTeacher";
    		
    	} else {
    		user.setEmail(email);
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	    String encodedPassword = passwordEncoder.encode(teacher.getPassword());
    	    user.setPassword(encodedPassword);
    	    Role userRole= roleRepo.findByName("teacher");
    		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    	    userRepo.save(user);
    	    teacher_Service.addTeacher(teacher);
       
    	}
    	
		
		return "redirect:/teachersList";
	}
	
	@GetMapping("/TeacherPanel")
	public String ShowTeacher(Model model) {
		model.addAttribute("Classroom",classroom_Service.showAll());
		return "teacherPanel";
	}
	@GetMapping("/teachersList")
	public String teacherList(Model model) {
		List<Teacher> teacher= teacher_Service.showAll(); 
		model.addAttribute("Teacher",teacher);
		return "teacher";
	}
}
