package com.school.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.school.model.Management_Team;
import com.school.service.Management_Team_Service;

@Controller
public class Management_Team_Controller {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 

	@Autowired
	private Management_Team_Service management_Team_Service;
	
	@GetMapping("/admin/School")
	public String view(Model model) {
		
		model.addAttribute("School",management_Team_Service.showAll().get(0));
		return "school";
	}
	@GetMapping("/editSchool/{id}/{fileName}")
	public String edit(Model model,@PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) {
		
		model.addAttribute("School",new Management_Team());
		model.addAttribute("filename",deletedFileName);
		model.addAttribute("id",id);
	
		return "updateSchool";
	}
	@PostMapping("/saveSchool/{id}/{fileName}")
	public String save(@Valid Management_Team management_Team,final @RequestParam("file") MultipartFile file, @PathVariable("id") Long Id,@PathVariable("fileName") String deletedFileName) throws IOException{
		String fileName = file.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		

		// Save the file locally
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(file.getBytes());
		stream.close();

		
		management_Team.setFileName(fileName);
		management_Team.setFilePath(filePath);
		management_Team.setFileType(fileType);
		management_Team_Service.removeAppearanceandFile(Id, fileName);
		
		management_Team_Service.add(management_Team);
		return "";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
