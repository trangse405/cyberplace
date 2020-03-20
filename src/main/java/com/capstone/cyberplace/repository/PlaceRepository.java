package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	@Query(value = "SELECT TOP(6) * from Place ORDER BY counter_view DESC ", nativeQuery = true) // jpql
	List<Place> getTop6();

	@Query(value = "SELECT  * from Place where place_id = :place_id ", nativeQuery = true) // jpql
	Place getOneByID(@Param("place_id") int place_id);

	// searchUltimate
	@Modifying
	@Query(value = "  SELECT * FROM Place where :query", nativeQuery = true) // jpql
	List<Place> listSearchPlace(@Param("query") String query);

}
