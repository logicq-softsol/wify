package com.logicq.wify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENER")
public class Genre {
	
	@Id
	@Column(name = "GENERS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long generId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DISPLAY_NAME")
	private String displayName;

	public Long getGenerId() {
		return generId;
	}

	public void setGenerId(Long generId) {
		this.generId = generId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
	

}
