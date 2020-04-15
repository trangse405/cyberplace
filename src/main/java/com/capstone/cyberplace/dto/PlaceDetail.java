package com.capstone.cyberplace.dto;

import java.util.List;

import com.capstone.cyberplace.dto.form.CostOfPlaceForm;
import com.capstone.cyberplace.dto.form.EquipmentListForm;

public class PlaceDetail {

	private int placeID;
	private String title;
	private float area;
	private float price;
	private String district;
	private String ward;
	private String street;
	private String address;
	private String longtitude;
	private String latitude;
	private String roleOfPlace;
	private int counterView;
	private String statusPlace;
	private int statusPlaceID;

	private float frontispiece;

	private String homeDirection;

	private int bedRooms;

	private int toilets;

	private String description;

	private String imageLarge;

	private List<String> listImage;

	private List<EquipmentListForm> listEquip;
	private List<CostOfPlaceForm> listCost;

	public PlaceDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getStatusPlace() {
		return statusPlace;
	}

	public void setStatusPlace(String statusPlace) {
		this.statusPlace = statusPlace;
	}

	public int getStatusPlaceID() {
		return statusPlaceID;
	}

	public void setStatusPlaceID(int statusPlaceID) {
		this.statusPlaceID = statusPlaceID;
	}

	public List<String> getListImage() {
		return listImage;
	}

	public void setListImage(List<String> listImage) {
		this.listImage = listImage;
	}

	public List<EquipmentListForm> getListEquip() {
		return listEquip;
	}

	public void setListEquip(List<EquipmentListForm> listEquip) {
		this.listEquip = listEquip;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRoleOfPlace() {
		return roleOfPlace;
	}

	public void setRoleOfPlace(String roleOfPlace) {
		this.roleOfPlace = roleOfPlace;
	}

	public int getCounterView() {
		return counterView;
	}

	public void setCounterView(int counterView) {
		this.counterView = counterView;
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

	public int getBedRooms() {
		return bedRooms;
	}

	public void setBedRooms(int bedRooms) {
		this.bedRooms = bedRooms;
	}

	public int getToilets() {
		return toilets;
	}

	public void setToilets(int toilets) {
		this.toilets = toilets;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLarge() {
		return imageLarge;
	}

	public void setImageLarge(String imageLarge) {
		this.imageLarge = imageLarge;
	}

	public List<CostOfPlaceForm> getListCost() {
		return listCost;
	}

	public void setListCost(List<CostOfPlaceForm> listCost) {
		this.listCost = listCost;
	}

}
