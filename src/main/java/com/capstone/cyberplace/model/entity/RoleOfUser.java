package com.capstone.cyberplace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RoleOfUser")
public class RoleOfUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private int roleID;

	@Column(name = "role_name", nullable = false)
	private String roleName;

	public RoleOfUser() {

	}

	public RoleOfUser(int roleID, String roleName) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
