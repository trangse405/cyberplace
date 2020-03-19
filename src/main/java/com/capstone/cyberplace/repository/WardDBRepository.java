package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.WardDB;

@Repository
public interface WardDBRepository extends JpaRepository<WardDB, Integer> {

	@Query(value = "SELECT id , district_id , ward_name FROM WardDB", nativeQuery = true) // jpql
	List<WardDB> getAllWard();
}
