package com.capstone.cyberplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.cyberplace.model.ContractStatus;

@Repository
public interface ContractStatusRepository extends JpaRepository<ContractStatus, Integer> {

	@Query(value = "SELECT * FROM ContractStatus ", nativeQuery = true) // jpql
	List<ContractStatus> getAllContractStatus();

}
