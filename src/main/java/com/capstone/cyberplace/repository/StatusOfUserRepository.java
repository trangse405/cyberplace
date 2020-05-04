package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.StatusOfUser;

@Repository
public interface StatusOfUserRepository  extends JpaRepository<StatusOfUser, Integer>{
	
	@Query(value = "SELECT * FROM StatusOfUser", nativeQuery = true) // jpql
	List<StatusOfUser> getAllStatus();

}
