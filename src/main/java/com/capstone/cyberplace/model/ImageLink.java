package com.capstone.cyberplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ImageLink")
public class ImageLink {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	
	@Column(name = "place_id", nullable = false)
	private int place_id;
	
	@Column(name = "image_link", nullable = false)
	private String image_link;
	
	
	public ImageLink() {
		// TODO Auto-generated constructor stub
	}


	public ImageLink(int id, int place_id, String image_link) {
		super();
		this.id = id;
		this.place_id = place_id;
		this.image_link = image_link;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPlace_id() {
		return place_id;
	}


	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}


	public String getImage_link() {
		return image_link;
	}


	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	
	
	

}
