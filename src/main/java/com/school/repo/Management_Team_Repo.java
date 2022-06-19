package com.school.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.model.Management_Team;


public interface Management_Team_Repo extends JpaRepository<Management_Team, Long> {
	
	@Transactional
	  @Modifying
	  @Query("delete from Management_Team b where b.Id like ?1 and fileName like ?2") 
	  public void deleteAppearanceWithFile(Long id, String fileName);


}
