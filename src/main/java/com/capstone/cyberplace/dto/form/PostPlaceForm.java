package com.capstone.cyberplace.dto.form;

import java.util.List;

public class PostPlaceForm {

	// page 1
	private int userID;
	private String title;
	private int roleOfPlaceID;
	private int districtID;
	private int wardID;
	private int streetID;
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

	public PostPlaceForm() {
		// TODO Auto-generated constructor stub
	}

	public PostPlaceForm(int userID, String title, int roleOfPlaceID, int districtID, int wardID, int streetID,
			float area, float price, String addressDetail, String descriptions, float frontispiece,
			String homeDirection, int numberFloors, int numberBedrooms, int numberToilets,
			List<EquipmentListForm> listEquip, List<String> listImageLink, String longtitude, String latitude,
			String contactName, String contactAddress, String phoneNumber, String email, String checkingDate) {
		super();
		this.userID = userID;
		this.title = title;
		this.roleOfPlaceID = roleOfPlaceID;
		this.districtID = districtID;
		this.wardID = wardID;
		this.streetID = streetID;
		this.area = area;
		this.price = price;
		this.addressDetail = addressDetail;
		this.descriptions = descriptions;
		this.frontispiece = frontispiece;
		this.homeDirection = homeDirection;
		this.numberFloors = numberFloors;
		this.numberBedrooms = numberBedrooms;
		this.numberToilets = numberToilets;
		this.listEquip = listEquip;
		this.listImageLink = listImageLink;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.contactName = contactName;
		this.contactAddress = contactAddress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.checkingDate = checkingDate;
	}

	public int getStreetID() {
		return streetID;
	}

	public void setStreetID(int streetID) {
		this.streetID = streetID;
	}

	public int getRoleOfPlaceID() {
		return roleOfPlaceID;
	}

	public void setRoleOfPlaceID(int roleOfPlaceID) {
		this.roleOfPlaceID = roleOfPlaceID;
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

	public int getDistrictID() {
		return districtID;
	}

	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}

	public int getWardID() {
		return wardID;
	}

	public void setWardID(int wardID) {
		this.wardID = wardID;
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

	public List<CostOfPlaceForm> getListCost() {
		return listCost;
	}

	public void setListCost(List<CostOfPlaceForm> listCost) {
		this.listCost = listCost;
	}

}
