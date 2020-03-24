package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.ImageLink;

@Repository
public interface ImageLinkRepository extends JpaRepository<ImageLink, Integer> {
	
	@Query(value = "SELECT * FROM ImageLink where place_id = :place_id ", nativeQuery = true) // jpql
	List<ImageLink> getListImageByPlaceID(@Param("place_id") int placeID);

}
