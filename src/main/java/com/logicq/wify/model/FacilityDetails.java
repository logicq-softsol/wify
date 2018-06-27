package com.logicq.wify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACILITY")
public class FacilityDetails {
	
	@Id
	@Column(name = "FACILITY_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facilityId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private Double price;


	@Column(name = "AVILABLE")
	private boolean isAvilable;

	@Column(name = "IMAGE")
	private String iconurl;

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
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

	public boolean isAvilable() {
		return isAvilable;
	}

	public void setAvilable(boolean isAvilable) {
		this.isAvilable = isAvilable;
	}

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	@Override
	public String toString() {
		return "FacilityDetails [facilityId=" + facilityId + ", name=" + name + ", price=" + price + ", isAvilable="
				+ isAvilable + ", iconurl=" + iconurl + "]";
	}
	
	

}
