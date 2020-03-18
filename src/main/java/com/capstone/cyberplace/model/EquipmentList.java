package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EquipmentList")
public class EquipmentList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipment_list_id", nullable = false)
	private int equipmentListId;

	@Column(name = "place_id", nullable = false)
	private int placeID;

	@Column(name = "equipment_name", nullable = false)
	private String equipmentName;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "price", nullable = false)
	private float price;

	@Column(name = "like_new", nullable = false)
	private int likeNew;

	@Column(name = "equipment_describe", nullable = false)
	private String equipmentDescribe;

	public EquipmentList() {
		// TODO Auto-generated constructor stub
	}

	public EquipmentList(int equipmentListId, int placeID, String equipmentName, int quantity, float price, int likeNew,
			String equipmentDescribe) {
		super();
		this.equipmentListId = equipmentListId;
		this.placeID = placeID;
		this.equipmentName = equipmentName;
		this.quantity = quantity;
		this.price = price;
		this.likeNew = likeNew;
		this.equipmentDescribe = equipmentDescribe;
	}

	public int getEquipmentListId() {
		return equipmentListId;
	}

	public void setEquipmentListId(int equipmentListId) {
		this.equipmentListId = equipmentListId;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getLikeNew() {
		return likeNew;
	}

	public void setLikeNew(int likeNew) {
		this.likeNew = likeNew;
	}

	public String getEquipmentDescribe() {
		return equipmentDescribe;
	}

	public void setEquipmentDescribe(String equipmentDescribe) {
		this.equipmentDescribe = equipmentDescribe;
	}

}
