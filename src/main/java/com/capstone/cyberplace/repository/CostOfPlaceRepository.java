package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.CostOfPlace;

@Repository
public interface CostOfPlaceRepository extends JpaRepository<CostOfPlace, Integer> {

	@Modifying
	@Query(value = "  INSERT INTO CostOfPlace (place_id ,cost_name , cost_price ,unit_id ) VALUES (:place_id , :cost_name , :cost_price , :unit_id )", nativeQuery = true) // jpql
	void insertItemCostOfPlace(@Param("place_id") int place_id, @Param("cost_name") String costName,
			@Param("cost_price") float costPrice, @Param("unit_id") int unitID);

	@Query(value = "  SELECT * FROM CostOfPlace where place_id =:place_id ", nativeQuery = true) // jpql
	List<CostOfPlace> getListCostByPlaceID(@Param("place_id") int place_id);

	@Modifying
	@Query(value = "DELETE FROM CostOfPlace where place_id = :place_id ", nativeQuery = true) // jpql
	void deleteListCostByPlaceID(@Param("place_id") int placeID);

	@Query(value = "  SELECT * FROM CostOfPlace where id =:id ", nativeQuery = true) // jpql
	CostOfPlace getCostOfPlaceByID(@Param("id") int id);

}
