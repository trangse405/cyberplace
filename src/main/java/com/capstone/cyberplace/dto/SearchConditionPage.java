package com.capstone.cyberplace.dto;

public class SearchConditionPage {

	private String title;
	private int roleOfPlaceID;
	private int districtID;
	private int areaMax;
	private int areaMin;
	private int priceMax;
	private int priceMin;
	private int page;
	private int number;

	public SearchConditionPage() {
		// TODO Auto-generated constructor stub
	}

	public SearchConditionPage(String title, int roleOfPlaceID, int districtID, int areaMax, int areaMin, int priceMax,
			int priceMin, int page, int number) {
		super();
		this.title = title;
		this.roleOfPlaceID = roleOfPlaceID;
		this.districtID = districtID;
		this.areaMax = areaMax;
		this.areaMin = areaMin;
		this.priceMax = priceMax;
		this.priceMin = priceMin;
		this.page = page;
		this.number = number;
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

	public int getDistrictID() {
		return districtID;
	}

	public void setDistrictID(int districtID) {
		this.districtID = districtID;
	}

	public int getAreaMax() {
		return areaMax;
	}

	public void setAreaMax(int areaMax) {
		this.areaMax = areaMax;
	}

	public int getAreaMin() {
		return areaMin;
	}

	public void setAreaMin(int areaMin) {
		this.areaMin = areaMin;
	}

	public int getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}

	public int getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
