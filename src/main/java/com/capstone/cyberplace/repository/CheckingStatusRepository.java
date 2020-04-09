package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.CheckingStatus;

@Repository
public interface CheckingStatusRepository extends JpaRepository<CheckingStatus, Integer> {

	
	@Query(value = "SELECT * FROM CheckingStatus ", nativeQuery = true) // jpql
	List<CheckingStatus> getAllCheckingStatus();
}
