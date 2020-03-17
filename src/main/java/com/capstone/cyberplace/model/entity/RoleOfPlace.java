package com.capstone.cyberplace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RoleOfPlace")
public class RoleOfPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_of_place_id", nullable = false)
	private int roleOfPlaceID;

	@Column(name = "role_name", nullable = false)
	private String roleName;

	public RoleOfPlace() {
		// TODO Auto-generated constructor stub
	}

	public RoleOfPlace(int roleOfPlaceID, String roleName) {
		super();
		this.roleOfPlaceID = roleOfPlaceID;
		this.roleName = roleName;
	}

	public int getRoleOfPlaceID() {
		return roleOfPlaceID;
	}

	public void setRoleOfPlaceID(int roleOfPlaceID) {
		this.roleOfPlaceID = roleOfPlaceID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
