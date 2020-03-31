package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.StreetDB;

@Repository
public interface StreetDBRepository extends JpaRepository<StreetDB, Integer> {

	@Query(value = "SELECT * FROM StreetDB", nativeQuery = true) // jpql
	List<StreetDB> getAllStreet();

	@Query(value = "SELECT * FROM StreetDB where id = :street_id", nativeQuery = true) // jpql
	StreetDB getOneStreetByID(@Param("street_id") int streetID);

	@Query(value = "SELECT * FROM StreetDB where ward_id =:ward_id", nativeQuery = true) // jpql
	List<StreetDB> getAllStreetByWardID(@Param("ward_id") int wardID);

}
