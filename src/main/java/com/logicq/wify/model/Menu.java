package com.logicq.wify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU")
public class Menu {

	@Id
	@Column(name = "MENU_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long menuId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "PRICE", nullable = false)
	private Double price;

	@Column(name = "OFFER_PRICE")
	private Double offerPrice;

	@Column(name = "TYPE", nullable = false)
	private String type;

	@Column(name = "CATEGORY", nullable = false)
	private String category;

	@Column(name = "AVILABLITY_TYPE")
	private String avlType;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "RATING")
	private Double rating;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAvlType() {
		return avlType;
	}

	public void setAvlType(String avlType) {
		this.avlType = avlType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", name=" + name + ", price=" + price + ", offerPrice=" + offerPrice
				+ ", type=" + type + ", category=" + category + ", avlType=" + avlType + ", description=" + description
				+ ", rating=" + rating + "]";
	}

	

}
