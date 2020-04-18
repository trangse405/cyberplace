package com.capstone.cyberplace.dto.form;

import java.util.List;

import com.capstone.cyberplace.dto.StreetData;
import com.capstone.cyberplace.dto.WardData;
import com.capstone.cyberplace.model.DistrictDB;

public class FillToUpdateForm {

	private DistrictDB district;
	private StreetData street;
	private WardData ward;
	// page 1
	private int userID;
	private String title;
	private int roleOfPlaceID;
	private float area;
	private float price;
	private String addressDetail;
	// page 2
	private String descriptions;
	// page3
	private float frontispiece;
	private String homeDirection;
	private int numberFloors;
	private int numberBedrooms;
	private int numberToilets;
	// page 4
	private List<EquipmentListForm> listEquip;
	// page5
	private List<String> listImageLink;

	// cost of place
	private List<CostOfPlaceForm> listCost;
	// page6
	private String longtitude;
	private String latitude;
	// page 7
	private String contactName;
	private String contactAddress;
	private String phoneNumber;
	private String email;
	private String checkingDate;

	public FillToUpdateForm() {
		// TODO Auto-generated constructor stub
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRoleOfPlaceID() {
		return roleOfPlaceID;
	}

	public void setRoleOfPlaceID(int roleOfPlaceID) {
		this.roleOfPlaceID = roleOfPlaceID;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public float getFrontispiece() {
		return frontispiece;
	}

	public void setFrontispiece(float frontispiece) {
		this.frontispiece = frontispiece;
	}

	public String getHomeDirection() {
		return homeDirection;
	}

	public void setHomeDirection(String homeDirection) {
		this.homeDirection = homeDirection;
	}

	public int getNumberFloors() {
		return numberFloors;
	}

	public void setNumberFloors(int numberFloors) {
		this.numberFloors = numberFloors;
	}

	public int getNumberBedrooms() {
		return numberBedrooms;
	}

	public void setNumberBedrooms(int numberBedrooms) {
		this.numberBedrooms = numberBedrooms;
	}

	public int getNumberToilets() {
		return numberToilets;
	}

	public void setNumberToilets(int numberToilets) {
		this.numberToilets = numberToilets;
	}

	public List<EquipmentListForm> getListEquip() {
		return listEquip;
	}

	public void setListEquip(List<EquipmentListForm> listEquip) {
		this.listEquip = listEquip;
	}

	public List<String> getListImageLink() {
		return listImageLink;
	}

	public void setListImageLink(List<String> listImageLink) {
		this.listImageLink = listImageLink;
	}

	public List<CostOfPlaceForm> getListCost() {
		return listCost;
	}

	public void setListCost(List<CostOfPlaceForm> listCost) {
		this.listCost = listCost;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCheckingDate() {
		return checkingDate;
	}

	public void setCheckingDate(String checkingDate) {
		this.checkingDate = checkingDate;
	}

	public DistrictDB getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDB district) {
		this.district = district;
	}

	public StreetData getStreet() {
		return street;
	}

	public void setStreet(StreetData street) {
		this.street = street;
	}

	public WardData getWard() {
		return ward;
	}

	public void setWard(WardData ward) {
		this.ward = ward;
	}

}
