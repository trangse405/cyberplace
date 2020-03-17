package com.capstone.cyberplace.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.entity.AreaDB;

@Repository
public interface AreaDBRepository extends JpaRepository<AreaDB, Integer>{
	
	@Query(value = "SELECT TOP (1000) [id]\r\n" + 
			
			"      ,[district]\r\n" + 
			
			"  FROM [CapstoneDB].[dbo].[AreaDB]", nativeQuery = true) // jpql
	List<AreaDB> getall();
	
	
	
	@Modifying
	@Query(value = "INSERT INTO [dbo].[AreaDB]\r\n"  + "           ([district])\r\n"
			+  "     VALUES\r\n" + "           (:district)", nativeQuery = true) // jpql
	void insertArea(@Param("district") String district);
	

}
