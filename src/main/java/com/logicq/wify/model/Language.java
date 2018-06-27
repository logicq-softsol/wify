package com.logicq.wify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LANGUAGE")
public class Language {

	@Id
	@Column(name = "LANG_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long langId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	public Long getLangId() {
		return langId;
	}

	public void setLangId(Long langId) {
		this.langId = langId;
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
