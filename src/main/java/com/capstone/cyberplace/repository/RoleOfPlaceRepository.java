package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.RoleOfPlace;

@Repository
public interface RoleOfPlaceRepository extends JpaRepository<RoleOfPlace, Integer> {

	@Query(value = "SELECT * FROM RoleOfPlace", nativeQuery = true) // jpql
	List<RoleOfPlace> getall();

}
