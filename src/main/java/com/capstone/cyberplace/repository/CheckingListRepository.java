package com.capstone.cyberplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.CheckingList;

@Repository
public interface CheckingListRepository extends JpaRepository<CheckingList, Integer> {

	@Modifying
	@Query(value = "INSERT INTO CheckingList (place_id , date_time , checking_status_id) VALUES (:place_id , :date_time , :checking_status_id)", nativeQuery = true) // jpql
	void insertItemToCheckingList(@Param("place_id") int place_id, @Param("date_time") String dateTime,
			@Param("checking_status_id") int checkingStatusID);
}
