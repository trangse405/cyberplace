package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.OrderStatus;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

	@Query(value = "SELECT * FROM OrderStatus ", nativeQuery = true) // jpql
	List<OrderStatus> getAllOrderStatus();
}
