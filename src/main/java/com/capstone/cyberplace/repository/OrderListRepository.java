package com.capstone.cyberplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.OrderList;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Integer> {

	@Modifying
	@Query(value = "INSERT INTO OrderList (orderer_id ,place_id ,order_status_id,  date_time , name , email , phone_number ) \r\n"
			+ "VALUES (:orderer_id , :place_id ,  :order_status_id , :date_time , :name , :email , :phone_number )", nativeQuery = true) // jpql
	void addOrder(@Param("orderer_id") int ordererID, @Param("place_id") int placeID,
			@Param("order_status_id") int orderStatusID, @Param("date_time") String dateTime,
			@Param("name") String name, @Param("email") String email, @Param("phone_number") String phoneNumber);

}
