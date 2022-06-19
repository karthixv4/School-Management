package com.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.model.Homework;

@Repository
public interface Homework_Repo extends JpaRepository<Homework, Long> {

}
