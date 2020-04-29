package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

	@Query(value = "SELECT * FROM Contract ", nativeQuery = true) // jpql
	List<Contract> getAllContract();

	@Query(value = "SELECT * FROM Contract where owner_id = :owner_id ", nativeQuery = true) // jpql
	List<Contract> getAllContractByOwnerID(@Param("owner_id") int owner_id);

	@Query(value = "SELECT * FROM Contract where renter_id = :renter_id ", nativeQuery = true) // jpql
	List<Contract> getAllContractByRenterID(@Param("renter_id") int renterID);

	@Query(value = "SELECT * FROM Contract where contract_id = :contract_id ", nativeQuery = true) // jpql
	Contract getContractByContractID(@Param("contract_id") int contractID);

	@Modifying
	@Query(value = "INSERT INTO Contract (owner_id , renter_id , place_id ,start_date ,end_date ,fee,contract_status_id ,order_id , is_use_service , contract_link) VALUES (:owner_id , :renter_id, :place_id, :start_date, :end_date, :fee, :contract_status_id , :order_id, :is_use_service , :contract_link)", nativeQuery = true) // jpql
	void insertContract(@Param("owner_id") int owner_id, @Param("renter_id") int renter_id,
			@Param("place_id") int place_id, @Param("start_date") String start_date, @Param("end_date") String end_date,
			@Param("fee") float fee, @Param("contract_status_id") int contract_status_id,
			@Param("order_id") int orderID, @Param("is_use_service") int is_use_service,
			@Param("contract_link") String contract_link);

	@Modifying
	@Query(value = "UPDATE Contract SET contract_status_id =:contract_status_id where contract_id =:contract_id ", nativeQuery = true) // jpql
	void changeStatusContractByContractID(@Param("contract_status_id") int contractStatusID,
			@Param("contract_id") int contractID);

}
