package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.StreetDB;


@Repository
public interface StreetDBRepository extends JpaRepository<StreetDBRepository, Integer> {

	
	
	@Query(value = "SELECT * FROM StreetDB", nativeQuery = true) // jpql
	List<StreetDB> getAllStreet();
}
