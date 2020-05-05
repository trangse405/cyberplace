package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.RoleOfUser;

@Repository
public interface RoleOfUserRepository extends JpaRepository<RoleOfUser, Integer> {

	@Query(value = "SELECT * FROM RoleOfUser", nativeQuery = true) // jpql
	List<RoleOfUser> getall();

	
	
	@Modifying
	@Query(value = " INSERT INTO RoleOfUser\r\n" + "           (role_name)\r\n" + "     VALUES\r\n"
			+ "           (:role) " + "			 ", nativeQuery = true) // jpql
	void insertRole(@Param("role") String role);
}
