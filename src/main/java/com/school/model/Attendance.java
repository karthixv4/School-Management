package com.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;
	
	@Column
	private String Roll_Number;
	
	@Column
	private String Name;
	
	@Column
	private String Grade;
	
	public String getRoll_Number() {
		return Roll_Number;
	}

	public void setRoll_Number(String roll_Number) {
		Roll_Number = roll_Number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	@Column 
	private String Attendance_Date;
	
	@Column
	private String Attendance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAttendance_Date() {
		return Attendance_Date;
	}

	public void setAttendance_Date(String attendance_Date) {
		Attendance_Date = attendance_Date;
	}

	public String getAttendance() {
		return Attendance;
	}

	public void setAttendance(String attendance) {
		Attendance = attendance;
	}
	
	

}
