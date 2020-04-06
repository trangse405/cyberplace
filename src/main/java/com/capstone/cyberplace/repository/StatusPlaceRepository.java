package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.StatusPlace;

@Repository
public interface StatusPlaceRepository  extends JpaRepository<StatusPlace, Integer>{
	
	@Query(value = "SELECT * FROM StatusPlace", nativeQuery = true) // jpql
	List<StatusPlace> getAllStatusPlace();


}
