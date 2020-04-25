package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.CostOfLivingBillDetail;

@Repository
public interface CostOfLivingBillDetailRepository extends JpaRepository<CostOfLivingBillDetail, Integer> {
	@Query(value = "SELECT * FROM CostOfLivingBillDetail   where col_id  = :col_id", nativeQuery = true) // jpql
	List<CostOfLivingBillDetail> getBillDetailByColID(@Param("col_id") int colID);

	@Modifying
	@Query(value = " INSERT INTO CostOfLivingBillDetail(col_id,cost_of_place_id,expense_per_cost,amount) VALUES (:col_id, :cost_of_place_id, :expense_per_cost, :amount)", nativeQuery = true) // jpql
	void insertCostOfLivingBillDetail(@Param("col_id") int colID, @Param("cost_of_place_id") int cost_of_place_id,
			@Param("expense_per_cost") float expensePerCost, @Param("amount") float amount);
	
	
	@Modifying
	@Query(value = "UPDATE CostOfLivingBillDetail SET amount =:amount where col_id =:col_id AND cost_of_place_id =:cost_of_place_id ", nativeQuery = true) // jpql
	void updateBillDetail(@Param("amount") float amount, @Param("col_id") int col_id, @Param("cost_of_place_id") int cost_of_place_id);
}
