package com.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Management_Team")
public class Management_Team {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long Id;
	
	@Column
	private String School_Name;
	
	@Column
	private String Description;
	
	@Column
	private String Address;
	
	@Column
	private Long Contact_Number;
	
	@Column
	private String Username;
	
	@Column 
	private String Password;
	
	@Column
	private String Principal_Name;
	
	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file_path")
	private String filePath;

	@Column(name = "file_type")
	private String fileType;



	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSchool_Name() {
		return School_Name;
	}

	public void setSchool_Name(String school_Name) {
		School_Name = school_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Long getContact_Number() {
		return Contact_Number;
	}

	public void setContact_Number(Long contact_Number) {
		Contact_Number = contact_Number;
	}

	public String getPrincipal_Name() {
		return Principal_Name;
	}

	public void setPrincipal_Name(String principal_Name) {
		Principal_Name = principal_Name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	

	 
}
