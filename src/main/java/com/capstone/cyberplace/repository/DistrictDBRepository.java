package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.DistrictDB;

@Repository
public interface DistrictDBRepository extends JpaRepository<DistrictDB, Integer> {

	@Query(value = "SELECT * FROM DistrictDB ORDER BY district_name ASC ", nativeQuery = true) // jpql
	List<DistrictDB> getall();

	@Modifying
	@Query(value = "INSERT INTO [dbo].[DistrictDB]\r\n" + "           ([district])\r\n" + "     VALUES\r\n"
			+ "           (:district)", nativeQuery = true) // jpql
	void insertArea(@Param("district") String district);

	@Query(value = "SELECT * FROM DistrictDB where id = :district_id", nativeQuery = true) // jpql
	DistrictDB getOneDistrictByID(@Param("district_id")int districtID);

}
