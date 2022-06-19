package com.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.Attendance;

public interface Attendance_Repo extends JpaRepository<Attendance, Long> {

}
