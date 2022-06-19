package com.school;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.school.controller.Teacher_Controller;

@SpringBootApplication
public class SchoolManagementApplication {

	public static void main(String[] args) {
		new File(Teacher_Controller.uploadDirectory).mkdir();
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

}
