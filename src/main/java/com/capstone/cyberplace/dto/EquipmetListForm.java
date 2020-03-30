package com.capstone.cyberplace.dto;

public class EquipmetListForm {
	private String name;
	private String quantity;
	private float price;
	private float likeNew;
	
	private String equipmentDescrible;

	public EquipmetListForm() {
		// TODO Auto-generated constructor stub
	}

	public EquipmetListForm(String name, String quantity, float price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
