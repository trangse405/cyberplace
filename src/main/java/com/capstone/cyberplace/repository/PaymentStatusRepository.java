package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.PaymentStatus;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Integer> {

	@Query(value = "SELECT * FROM BillStatus", nativeQuery = true) // jpql
	List<PaymentStatus> getAllPaymentStatus();

}
