package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.OrderList;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Integer> {

	// insert new order for user to come and see the house
	@Modifying
	@Query(value = "INSERT INTO OrderList (orderer_id ,place_id ,order_status_id,  date_time , name , email , phone_number ,message  ) \r\n"
			+ "VALUES (:orderer_id , :place_id ,  :order_status_id , :date_time , :name , :email , :phone_number,:message )", nativeQuery = true) // jpql
	void addOrder(@Param("orderer_id") int ordererID, @Param("place_id") int placeID,
			@Param("order_status_id") int orderStatusID, @Param("date_time") String dateTime,
			@Param("name") String name, @Param("email") String email, @Param("phone_number") String phoneNumber,
			@Param("message") String message);

	// change status order by order id + staff id
	@Modifying
	@Query(value = "UPDATE OrderList SET order_status_id = :order_status_id , staff_id =:staff_id  where order_id = :order_id ", nativeQuery = true)
	void changeStatusOrderWithStaff(@Param("order_status_id") int orderStatusID, @Param("staff_id") int staffID,
			@Param("order_id") int orderID);

	// update information of order

	@Modifying
	@Query(value = "UPDATE OrderList SET date_time = :date_time , name =:name ,email=:email, phone_number=:phone_number , message=:message  where order_id = :order_id ", nativeQuery = true)
	void updateOrder(@Param("date_time") String dateTime, @Param("name") String name, @Param("email") String email,
			@Param("phone_number") String phoneNumber, @Param("message") String message,
			@Param("order_id") int orderID);

	// get Order by Place ID and User ID
	@Query(value = "SELECT * FROM OrderList where place_id = :place_id and orderer_id =:orderer_id ", nativeQuery = true) // jpql
	OrderList getOrderByPlaceIDAndUserID(@Param("place_id") int placeID, @Param("orderer_id") int ordererID);

	// change status order
	@Modifying
	@Query(value = "UPDATE OrderList SET order_status_id = :order_status_id where order_id = :order_id ", nativeQuery = true)
	void changeStatusOrder(@Param("order_status_id") int orderStatusID, @Param("order_id") int orderID);

	// get Order User ID
	@Query(value = "SELECT * FROM OrderList where  orderer_id =:orderer_id ORDER BY order_id DESC", nativeQuery = true) // jpql
	List<OrderList> getOrderListUserID(@Param("orderer_id") int ordererID);

	// get all order
	@Query(value = "SELECT * FROM OrderList ORDER BY order_id DESC", nativeQuery = true) // jpql
	List<OrderList> getAllOrder();
	
	// get order pending by placeid
		@Query(value = "SELECT * FROM OrderList where place_id = :place_id and order_status_id =2 ", nativeQuery = true) // jpql
		List<OrderList> getAllOrderPendingByPlaceID(@Param("place_id") int place_id);
		
		
	
}
