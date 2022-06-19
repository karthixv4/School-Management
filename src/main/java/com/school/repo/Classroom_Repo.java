package com.school.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.model.Classroom;
import com.school.model.Student;



@Repository
public interface Classroom_Repo extends JpaRepository<Classroom, Long> {


}
