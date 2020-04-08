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
	@Query(value = " INSERT INTO Map (latitude , longtitude , place_id) VALUES (:latitude , :longtitude , :place_id)", nativeQuery = true) // jpql
	void insertMap(@Param("latitude") String latitude, @Param("longtitude") String longtitude,
			@Param("place_id") int place_id);

	@Query(value = "SELECT * FROM Map where place_id = :place_id ", nativeQuery = true) // jpql
	Map getMapIDByPlaceID(@Param("place_id") int place_id);
	
	
	@Modifying
	@Query(value = " UPDATE Map SET longtitude = :longtitude , latitude = :latitude where place_id = :place_id", nativeQuery = true) // jpql
	void updateMap(@Param("latitude") String latitude, @Param("longtitude") String longtitude,
			@Param("place_id") int place_id);

}
