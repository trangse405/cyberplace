package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CostOfPlace")
public class CostOfPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "place_id", nullable = false)
	private int placeID;
	@Column(name = "cost_name")
	private String costName;
	@Column(name = "cost_price")
	private float costPrice;

	public CostOfPlace() {
		// TODO Auto-generated constructor stub
	}

	public CostOfPlace(int id, int placeID, String costName, float costPrice) {
		super();
		this.id = id;
		this.placeID = placeID;
		this.costName = costName;
		this.costPrice = costPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

}
