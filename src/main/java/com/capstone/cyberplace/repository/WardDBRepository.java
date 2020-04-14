package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.WardDB;

@Repository
public interface WardDBRepository extends JpaRepository<WardDB, Integer> {

	@Query(value = "SELECT id , district_id , ward_name FROM WardDB", nativeQuery = true) // jpql
	List<WardDB> getAllWard();

	@Query(value = "SELECT * FROM WardDB where id = :ward_id", nativeQuery = true) // jpql
	WardDB getOneWardByID(@Param("ward_id") int wardID);

	@Query(value = "SELECT * FROM WardDB where district_id = :district_id ORDER BY ward_name ASC", nativeQuery = true) // jpql
	List<WardDB> getAllWardByDistrictID(@Param("district_id") int districtID);

}
