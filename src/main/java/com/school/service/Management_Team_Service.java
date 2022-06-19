package com.school.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Management_Team;
import com.school.repo.Management_Team_Repo;

@Service
public class Management_Team_Service {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 

	@Autowired
	private Management_Team_Repo management_Team_Repo;
	
	public void add(Management_Team management_Team) {
		management_Team_Repo.save(management_Team);
	}
	public <Management_Team>List showAll(){
		return management_Team_Repo.findAll();
	}
	public void removeAppearanceandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				management_Team_Repo.deleteAppearanceWithFile(Id, fileName); 
			
				String path = uploadDirectory + "/" + fileName;
				System.out.println("Path=" + path);
				File fileToDelete = new File(path);
				fileToDelete.delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
