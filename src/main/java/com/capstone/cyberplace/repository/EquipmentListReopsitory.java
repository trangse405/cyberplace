package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.EquipmentList;

@Repository
public interface EquipmentListReopsitory extends JpaRepository<EquipmentList, Integer> {

	@Modifying
	@Query(value = " INSERT INTO EquipmentList(place_id , equipment_name , quantity , price , like_new , equipment_describe) VALUES (:place_id , :equipment_name , :quantity,"
			+ " :price , :like_new , :equipment_describe)", nativeQuery = true) // jpql
	void insertEquipmentItem(@Param("place_id") int placeID, @Param("equipment_name") String equipmentName,
			@Param("quantity") int quantity, @Param("price") float price, @Param("like_new") int likeNew,
			@Param("equipment_describe") String equipmentDescribe);
	
	
	
	@Query(value = "SELECT * FROM EquipmentList where place_id = :place_id ", nativeQuery = true) // jpql
	List<EquipmentList> getListEquipByPlaceID(@Param("place_id") int placeID);
	
	
	@Modifying
	@Query(value = "DELETE FROM EquipmentList where place_id = :place_id ", nativeQuery = true) // jpql
	void deleteListEquipByPlaceID(@Param("place_id") int placeID);
	
	
	
	
	

}
