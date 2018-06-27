package com.logicq.wify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_TYPE")
public class ResturantMenuTypes {
	
	@Id
	@Column(name = "TYPE", nullable = false)
	private String menuType;

	
	@Column(name = "DISPLAY_NAME", nullable = false)
	private String displayName;


	@Column(name = "MENU_TYPE_ENABLE", nullable = false)
	private boolean isEnable;


	public String getMenuType() {
		return menuType;
	}


	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public boolean isEnable() {
		return isEnable;
	}


	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}


	@Override
	public String toString() {
		return "ResturantMenuTypes [menuType=" + menuType + ", displayName=" + displayName + ", isEnable=" + isEnable
				+ "]";
	}
	
	
	

}
