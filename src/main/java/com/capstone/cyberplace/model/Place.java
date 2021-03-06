package com.capstone.cyberplace.model;

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

	@Column(name = "district_id", nullable = false)
	private int district_id;

	@Column(name = "ward_id", nullable = false)
	private int ward_id;

	@Column(name = "street_id", nullable = false)
	private int street_id;

	@Column(name = "address")
	private String address;

	@Column(name = "role_of_place_id", nullable = false)
	private int roleOfPlaceID;

	@Column(name = "status_place_id", nullable = false)
	private int statusPlaceID;

	@Column(name = "counter_view")
	private int counterView;

	@Column(name = "frontispiece")
	private float frontispiece;

	@Column(name = "home_direction")
	private String homeDirection;

	@Column(name = "floors")
	private int floors;

	@Column(name = "bed_rooms")
	private int bedRooms;

	@Column(name = "toilets")
	private int toilets;

	@Column(name = "description")
	private String description;

	@Column(name = "image_large")
	private String image_large;

	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_phone_number")
	private String contactPhoneNumber;
	@Column(name = "contact_address")
	private String contactAddress;
	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "date_post")
	private String datePost;

	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(int placeID, int ownerID, String title, float price, float area, int district_id, int ward_id,
			int street_id, String address, int roleOfPlaceID, int statusPlaceID, int counterView, float frontispiece,
			String homeDirection, int floors, int bedRooms, int toilets, String description, String image_large,
			String contactName, String contactPhoneNumber, String contactAddress, String contactEmail,
			String datePost) {
		super();
		this.placeID = placeID;
		this.ownerID = ownerID;
		this.title = title;
		this.price = price;
		this.area = area;
		this.district_id = district_id;
		this.ward_id = ward_id;
		this.street_id = street_id;
		this.address = address;
		this.roleOfPlaceID = roleOfPlaceID;
		this.statusPlaceID = statusPlaceID;
		this.counterView = counterView;
		this.frontispiece = frontispiece;
		this.homeDirection = homeDirection;
		this.floors = floors;
		this.bedRooms = bedRooms;
		this.toilets = toilets;
		this.description = description;
		this.image_large = image_large;
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
		this.contactAddress = contactAddress;
		this.contactEmail = contactEmail;
		this.datePost = datePost;
	}

	public String getDatePost() {
		return datePost;
	}

	public void setDatePost(String datePost) {
		this.datePost = datePost;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public int getWard_id() {
		return ward_id;
	}

	public void setWard_id(int ward_id) {
		this.ward_id = ward_id;
	}

	public int getStreet_id() {
		return street_id;
	}

	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getImage_large() {
		return image_large;
	}

	public void setImage_large(String image_large) {
		this.image_large = image_large;
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

}
