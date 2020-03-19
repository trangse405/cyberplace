package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	@Query(value = "SELECT TOP(6) * from Place ORDER BY counter_view DESC ", nativeQuery = true) // jpql
	List<Place> getTop6();
	
	
//	@Query(value = "SELECT TOP(6) p.place_id,p.title , p.description,p.area,p.price	,p.role_of_place_id,p.image_large,p.floors from Place p  ORDER BY counter_view DESC", nativeQuery = true) // jpql
//	List<Place> getTop6();





	
}
