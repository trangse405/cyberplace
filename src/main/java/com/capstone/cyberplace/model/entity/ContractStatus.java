package com.capstone.cyberplace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ContractStatus")
public class ContractStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_status_id", nullable = false)
	private int contractStatusID;

	@Column(name = "contract_status_name", nullable = false)
	private String contractStatusName;

	public ContractStatus() {
		// TODO Auto-generated constructor stub
	}

	public ContractStatus(int contractStatusID, String contractStatusName) {
		super();
		this.contractStatusID = contractStatusID;
		this.contractStatusName = contractStatusName;
	}

	public int getContractStatusID() {
		return contractStatusID;
	}

	public void setContractStatusID(int contractStatusID) {
		this.contractStatusID = contractStatusID;
	}

	public String getContractStatusName() {
		return contractStatusName;
	}

	public void setContractStatusName(String contractStatusName) {
		this.contractStatusName = contractStatusName;
	}

}
