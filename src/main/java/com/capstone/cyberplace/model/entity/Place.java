package com.capstone.cyberplace.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Place")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_id", nullable = false)
	private int placeID;

	@Column(name = "owner_id", nullable = false)
	private int ownerID;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "price", nullable = false)
	private float price;

	@Column(name = "area", nullable = false)
	private float area;

	@Column(name = "district", nullable = false)
	private String district;

	@Column(name = "sub_district", nullable = false)
	private String sub_district;

	@Column(name = "street", nullable = false)
	private String street;

	@Column(name = "lane", nullable = false)
	private String lane;

	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "map_id", nullable = false)
	private int mapID;

	@Column(name = "role_of_place_id", nullable = false)
	private int roleOfPlaceID;

	@Column(name = "status_place_id", nullable = false)
	private int statusPlaceID;

	@Column(name = "counter_view", nullable = false)
	private int counterView;

	@Column(name = "frontispiece", nullable = false)
	private float frontispiece;

	@Column(name = "home_direction", nullable = false)
	private String homeDirection;

	@Column(name = "floors", nullable = false)
	private int floors;

	@Column(name = "bed_rooms", nullable = false)
	private int bedRooms;

	@Column(name = "toilets", nullable = false)
	private int toilets;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "video_link", nullable = false)
	private String videoLink;

	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(int placeID, int ownerID, String title, float price, float area, String district, String sub_district,
			String street, String lane, String number, int mapID, int roleOfPlaceID, int statusPlaceID, int counterView,
			float frontispiece, String homeDirection, int floors, int bedRooms, int toilets, String description,
			String videoLink) {
		super();
		this.placeID = placeID;
		this.ownerID = ownerID;
		this.title = title;
		this.price = price;
		this.area = area;
		this.district = district;
		this.sub_district = sub_district;
		this.street = street;
		this.lane = lane;
		this.number = number;
		this.mapID = mapID;
		this.roleOfPlaceID = roleOfPlaceID;
		this.statusPlaceID = statusPlaceID;
		this.counterView = counterView;
		this.frontispiece = frontispiece;
		this.homeDirection = homeDirection;
		this.floors = floors;
		this.bedRooms = bedRooms;
		this.toilets = toilets;
		this.description = description;
		this.videoLink = videoLink;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSub_district() {
		return sub_district;
	}

	public void setSub_district(String sub_district) {
		this.sub_district = sub_district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getMapID() {
		return mapID;
	}

	public void setMapID(int mapID) {
		this.mapID = mapID;
	}

	public int getRoleOfPlaceID() {
		return roleOfPlaceID;
	}

	public void setRoleOfPlaceID(int roleOfPlaceID) {
		this.roleOfPlaceID = roleOfPlaceID;
	}

	public int getStatusPlaceID() {
		return statusPlaceID;
	}

	public void setStatusPlaceID(int statusPlaceID) {
		this.statusPlaceID = statusPlaceID;
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

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
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

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

}
