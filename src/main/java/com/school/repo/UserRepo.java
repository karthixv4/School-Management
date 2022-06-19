package com.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.model.Users;

public interface UserRepo extends JpaRepository<Users, Long>{
	
	 @Query("SELECT u FROM Users u WHERE u.email = ?1")
	    public Users findByEmail(String email);

}
