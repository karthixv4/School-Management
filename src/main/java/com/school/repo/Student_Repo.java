package com.school.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.model.Student;

@Repository
public interface Student_Repo  extends JpaRepository<Student, Long>  {

	@Query(value="SELECT a FROM Student a WHERE Classroom_Id LIKE ?1")
	 public List<Student> findStudentById(Long id);
}