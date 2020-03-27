package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Users\r\n" + "           (user_name\r\n" + "           ,password\r\n"
			+ "           ,role_id\r\n" + "           ,status_id         \r\n" + "           \r\n" + "           )\r\n"
			+ "     VALUES\r\n" + "           (:uname, :upass, :roleid, :statusid)", nativeQuery = true) // jpql
	void register(@Param("uname") String uname, @Param("upass") String upass, @Param("roleid") int roleid,
			@Param("statusid") int statusid);

	//find user by username
	@Query(value = "SELECT * FROM Users  where user_name = :user_name", nativeQuery = true) // jpql
	User findUserByUserName(@Param("user_name") String user_name);

	@Query(value = "SELECT * FROM Users  where user_name = :user_name and password =:password", nativeQuery = true) // jpql
	User checkLogin(@Param("user_name") String user_name, @Param("password") String password);

	// get all staff

	@Query(value = "SELECT * FROM Users where role_id = 2", nativeQuery = true) // jpql
	List<User> getAllStaff();

	// get all user
	@Query(value = "SELECT * FROM Users where role_id = 4", nativeQuery = true) // jpql
	List<User> getAllUser();
	
	// insert name to userdetail

	
	

}
