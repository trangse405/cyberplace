package com.capstone.cyberplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer>{
	
	@Query(value = "SELECT * FROM Map where map_id = :map_id ", nativeQuery = true) // jpql
	Map getOneByMapID(@Param("map_id") int map_id);

}
