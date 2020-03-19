package com.capstone.cyberplace.dto;

public class PlaceQuickView {

	private int placeID;
	private String title;
	private String district;
	private float area;
	private float price;
	private String roleOfPlaceName;
	private String imageLarge;
	private int bedRooms;
	private int toilets;

	public PlaceQuickView() {
		// TODO Auto-generated constructor stub
	}

	

	public PlaceQuickView(int placeID, String title, String district, float area, float price, String roleOfPlaceName,
			String imageLarge, int bedRooms, int toilets) {
		super();
		this.placeID = placeID;
		this.title = title;
		this.district = district;
		this.area = area;
		this.price = price;
		this.roleOfPlaceName = roleOfPlaceName;
		this.imageLarge = imageLarge;
		this.bedRooms = bedRooms;
		this.toilets = toilets;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getRoleOfPlaceName() {
		return roleOfPlaceName;
	}

	public void setRoleOfPlaceName(String roleOfPlaceName) {
		this.roleOfPlaceName = roleOfPlaceName;
	}

	public String getImageLarge() {
		return imageLarge;
	}

	public void setImageLarge(String imageLarge) {
		this.imageLarge = imageLarge;
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



	

}
