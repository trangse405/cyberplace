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
	private String longtitude;

	@Column(name = "latitude", nullable = false)
	private String latitude;

	@Column(name = "place_id")
	private Integer placeID;

	public Map() {
		// TODO Auto-generated constructor stub
	}

	public Map(int mapID, String longtitude, String latitude, Integer placeID) {
		super();
		this.mapID = mapID;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.placeID = placeID;
	}

	public Integer getPlaceID() {
		return placeID;
	}

	public void setPlaceID(Integer placeID) {
		this.placeID = placeID;
	}

	public int getMapID() {
		return mapID;
	}

	public void setMapID(int mapID) {
		this.mapID = mapID;
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

}
