package com.capstone.cyberplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer> {

	@Query(value = "SELECT * FROM Map where map_id = :map_id ", nativeQuery = true) // jpql
	Map getOneByMapID(@Param("map_id") int map_id);

	@Modifying
	@Query(value = " INSERT INTO Map (latitude , longtitude) VALUES (:latitude , :longtitude)", nativeQuery = true) // jpql
	void insertMap(@Param("latitude") float latitude, @Param("longtitude") float longtitude);

	@Query(value = "SELECT * FROM Map where latitude = :latitude AND longtitude = :longtitude ", nativeQuery = true) // jpql
	Map getMapIDByLongtitudeAndLatitude(@Param("latitude") float latitude, @Param("longtitude") float longtitude);

}
