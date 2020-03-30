package com.capstone.cyberplace.dto.form;

public class EquipmentListForm {
	private String name;
	private int quantity;
	private float price;
	private int likeNew;

	private String equipmentDescrible;

	public EquipmentListForm() {
		// TODO Auto-generated constructor stub
	}

	public EquipmentListForm(String name, int quantity, float price, int likeNew, String equipmentDescrible) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.likeNew = likeNew;
		this.equipmentDescrible = equipmentDescrible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikeNew() {
		return likeNew;
	}

	public void setLikeNew(int likeNew) {
		this.likeNew = likeNew;
	}

	public String getEquipmentDescrible() {
		return equipmentDescrible;
	}

	public void setEquipmentDescrible(String equipmentDescrible) {
		this.equipmentDescrible = equipmentDescrible;
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

}
