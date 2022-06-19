package com.school.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.model.Teacher;


@Repository
public interface Teacher_Repo  extends JpaRepository<Teacher, Long>  {

	@Query(value="SELECT a FROM Teacher a WHERE Email LIKE %?1%")
	 public List<Teacher> findTeacherByEmail(String email);
}

