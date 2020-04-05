package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.ImageLink;

@Repository
public interface ImageLinkRepository extends JpaRepository<ImageLink, Integer> {
	
	@Query(value = "SELECT * FROM ImageLink where place_id = :place_id ", nativeQuery = true) // jpql
	List<ImageLink> getListImageByPlaceID(@Param("place_id") int placeID);
	
	@Modifying
	@Query(value = " INSERT INTO ImageLink (place_id , image_link ) VALUES (:place_id , :image_link)", nativeQuery = true) // jpql
	void insertImageLink(@Param("place_id") int place_id, @Param("image_link") String image_link);
	
	@Modifying
	@Query(value = "DELETE FROM ImageLink where place_id = :place_id ", nativeQuery = true) // jpql
	void deleteListImageByPlaceID(@Param("place_id") int placeID);

}
