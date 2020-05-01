package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	@Modifying
	@Query(value = "INSERT INTO Payment (user_id, place_id , create_time , status , payer_id , money ,description , order_id) "
			+ "VALUES (:user_id , :place_id , :create_time , :status , :payer_id , :money , :description , :order_id)", nativeQuery = true) // jpql
	void insertPaymentInfo(@Param("user_id") int userID, @Param("place_id") int placeID,
			@Param("create_time") String createTime, @Param("status") String status, @Param("payer_id") String payerID,
			@Param("money") float money, @Param("description") String description ,@Param("order_id") String order_id );

	
	@Query(value = "SELECT * FROM Payment", nativeQuery = true) // jpql
	List<Payment> getAllPayment();
	
	@Query(value = "SELECT * FROM Payment where user_id = :user_id", nativeQuery = true) // jpql
	List<Payment> getPaymentByUserID(@Param("user_id") int userID);
}
