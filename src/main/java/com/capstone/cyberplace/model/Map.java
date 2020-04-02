package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Map")
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "map_id", nullable = false)
	private int mapID;

	@Column(name = "longtitude", nullable = false)
	private float longtitude;

	@Column(name = "latitude", nullable = false)
	private float latitude;

	@Column(name = "place_id")
	private int placeID;

	public Map() {
		// TODO Auto-generated constructor stub
	}

	public Map(int mapID, float longtitude, float latitude, int placeID) {
		super();
		this.mapID = mapID;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.placeID = placeID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public int getMapID() {
		return mapID;
	}

	public void setMapID(int mapID) {
		this.mapID = mapID;
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

}
