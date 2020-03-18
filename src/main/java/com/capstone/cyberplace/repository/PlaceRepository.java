package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

	@Query(value = "SELECT * FROM Place", nativeQuery = true) // jpql
	List<Place> getTop6();

//	
//	@Query("SELECT p FROM Place p WHERE (:title is null or p.title = :title) and (:district is null"
//			+ " or p.district = :district) and (:role is null or p.role_of_place_id = :role)"
//			+ "and (p.price BETWEEN :minprice AND :maxprice) and (p.area BETWEEN :minarea AND :maxarea) ") // jpql
//	List<Place> searchHome(@Param("title") String title, @Param("district") String district,
//			@Param("role") int role_of_place_id, @Param("minprice") int minprice,
//			@Param("maxprice") int maxprice, @Param("minarea") int minarea, @Param("maxarea") int maxarea);
}
