package com.capstone.cyberplace.dto;

public class Place_RoleName {

	private int place_id;
	private String title;
	private String description;
	private float area;
	private float price;
	private String role_of_place_name;
	private String image_large;
	private int rooms;
	
	public Place_RoleName() {
		// TODO Auto-generated constructor stub
	}

	public Place_RoleName(int place_id, String title, String description, float area, float price,
			String role_of_place_name, String image_large, int rooms) {
		super();
		this.place_id = place_id;
		this.title = title;
		this.description = description;
		this.area = area;
		this.price = price;
		this.role_of_place_name = role_of_place_name;
		this.image_large = image_large;
		this.rooms = rooms;
	}

	public int getPlace_id() {
		return place_id;
	}

	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRole_of_place_name() {
		return role_of_place_name;
	}

	public void setRole_of_place_name(String role_of_place_name) {
		this.role_of_place_name = role_of_place_name;
	}

	public String getImage_large() {
		return image_large;
	}

	public void setImage_large(String image_large) {
		this.image_large = image_large;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	
	
	
}
