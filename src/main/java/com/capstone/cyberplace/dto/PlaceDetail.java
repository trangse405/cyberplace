package com.capstone.cyberplace.dto;

public class PlaceDetail {

	private int placeID;

	private String title;

	private float area;

	private float price;

	private String district;

	private String ward;

	private String street;

	private String address;

	private float longtitude;

	private float latitude;

	private String roleOfPlace;

	private int counterView;

	private float frontispiece;

	private String homeDirection;

	private int bedRooms;

	private int toilets;

	private String description;

	private String imageLarge;

	public PlaceDetail() {
		// TODO Auto-generated constructor stub
	}

	public PlaceDetail(int placeID, String title, float area, float price, String district, String ward, String street,
			String address, float longtitude, float latitude, String roleOfPlace, int counterView, float frontispiece,
			String homeDirection, int bedRooms, int toilets, String description, String imageLarge) {
		super();
		this.placeID = placeID;
		this.title = title;
		this.area = area;
		this.price = price;
		this.district = district;
		this.ward = ward;
		this.street = street;
		this.address = address;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.roleOfPlace = roleOfPlace;
		this.counterView = counterView;
		this.frontispiece = frontispiece;
		this.homeDirection = homeDirection;
		this.bedRooms = bedRooms;
		this.toilets = toilets;
		this.description = description;
		this.imageLarge = imageLarge;
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

	public float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
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

}
