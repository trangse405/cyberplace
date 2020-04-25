package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.CostOfLivingBill;

@Repository
public interface CostOfLivingBillRepository extends JpaRepository<CostOfLivingBill, Integer> {

	@Modifying
	@Query(value = " INSERT INTO CostOfLivingBill(contract_id , date_collect , total_expense ,payment_status_id) VALUES (:contract_id, :date_collect, :total_expense, :payment_status_id)", nativeQuery = true) // jpql
	void insertCostOfLivingBill(@Param("contract_id") int contractID, @Param("date_collect") String dateCollect,
			@Param("total_expense") float totalExpense, @Param("payment_status_id") int paymentStatusID);

	@Query(value = "SELECT * FROM CostOfLivingBill where date_collect < GETDATE() + 31 ", nativeQuery = true) // jpql
	List<CostOfLivingBill> getAllBillBefore30Days();

	@Query(value = "SELECT * FROM CostOfLivingBill where date_collect < GETDATE() + 31 AND contract_id = :contract_id", nativeQuery = true) // jpql
	CostOfLivingBill getAllBillBefore30DaysByContractID(@Param("contract_id") int contractID);

	@Query(value = "SELECT * FROM CostOfLivingBill where  contract_id = :contract_id", nativeQuery = true) // jpql
	List<CostOfLivingBill> getAllBillByContractID(@Param("contract_id") int contractID);

	@Modifying
	@Query(value = " UPDATE CostOfLivingBill SET total_expense =:total_expense where col_id =:col_id ", nativeQuery = true) // jpql
	void updateTotal(@Param("total_expense") float totalExpense, @Param("col_id") int coliD);

	@Query(value = "SELECT * FROM CostOfLivingBill where col_id = :col_id", nativeQuery = true) // jpql
	CostOfLivingBill getBillByColID(@Param("col_id") int colID);

	@Modifying
	@Query(value = " UPDATE CostOfLivingBill SET payment_status_id = :payment_status_id where col_id = :col_id ", nativeQuery = true) // jpql
	void changeStatus(@Param("payment_status_id") int paymentStatusId, @Param("col_id") int colID);
}
