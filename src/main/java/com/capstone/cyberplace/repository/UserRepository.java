package com.capstone.cyberplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO Users\r\n" + 
			"           (user_name\r\n" + 
			"           ,password\r\n" + 
			"           ,role_id\r\n" + 
			"           ,status_id         \r\n" + 
			"           ,email\r\n" + 
			"           )\r\n" + 
			"     VALUES\r\n" + 
			"           (:uname, :upass, :roleid, :statusid, :email)", nativeQuery = true) // jpql
	void register(@Param("uname") String uname, @Param("upass") String upass 
			, @Param("roleid") int roleid , @Param("statusid") int statusid ,@Param("email") String emai);

}
