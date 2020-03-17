package com.capstone.cyberplace.model.cp;

import java.util.List;

import com.capstone.cyberplace.model.entity.AreaDB;
import com.capstone.cyberplace.model.entity.Place;
import com.capstone.cyberplace.model.entity.RoleOfPlace;

public class CPHome {

	List<Place> listPlace;
	
	List<RoleOfPlace> listRoleOfPlace;
	
	List<AreaDB> listArea ; 
		
	public CPHome() {
		// TODO Auto-generated constructor stub
	}

	public CPHome(List<Place> listPlace, List<RoleOfPlace> listRoleOfPlace, List<AreaDB> listArea) {
		super();
		this.listPlace = listPlace;
		this.listRoleOfPlace = listRoleOfPlace;
		this.listArea = listArea;
	}

	public List<Place> getListPlace() {
		return listPlace;
	}

	public void setListPlace(List<Place> listPlace) {
		this.listPlace = listPlace;
	}

	public List<RoleOfPlace> getListRoleOfPlace() {
		return listRoleOfPlace;
	}

	public void setListRoleOfPlace(List<RoleOfPlace> listRoleOfPlace) {
		this.listRoleOfPlace = listRoleOfPlace;
	}

	public List<AreaDB> getListArea() {
		return listArea;
	}

	public void setListArea(List<AreaDB> listArea) {
		this.listArea = listArea;
	}
	
	
	
	
	
	
	
	
}
