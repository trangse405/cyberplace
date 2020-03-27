package com.capstone.cyberplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

	@Modifying
	@Query(value = " INSERT INTO UserDetail (user_id , name , gender , day_of_birth , address , phone_number , email , bank_account , avatar_link )"
			+ "VALUES (:user_id , :name , :gender , :day_of_birth , :address , :phone_number,:email , :bank_account , :avatar_link )", nativeQuery = true) // jpql
	void insertUserDetail(@Param("user_id") int userID, @Param("name") String name, @Param("gender") String gender,
			@Param("day_of_birth") String dayOfBirth, @Param("address") String address,
			@Param("phone_number") String phoneNumber, @Param("email") String email,
			@Param("bank_account") String bankAccount, @Param("avatar_link") String avatarLink);

	@Modifying
	@Query(value = " INSERT INTO UserDetail (user_id,name) VALUES (:user_id,:name)", nativeQuery = true) // jpql
	void insertNameToUserDetail(@Param("user_id") int userID, @Param("name") String name);

	// get detail by user id
	@Query(value = " SELECT * FROM UserDetail where user_id =:user_id", nativeQuery = true) // jpql
	UserDetail getDetailByUserID(@Param("user_id") int userID);
}
