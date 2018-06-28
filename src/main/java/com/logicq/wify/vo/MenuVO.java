package com.logicq.wify.vo;

public class MenuVO {

	private long menuId;
	private int quantity;
	private Double totalMenuPrice;
	private Double price;

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalMenuPrice() {
		return totalMenuPrice;
	}

	public void setTotalMenuPrice(Double totalMenuPrice) {
		this.totalMenuPrice = totalMenuPrice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuVO [menuId=" + menuId + ", quantity=" + quantity + ", totalMenuPrice=" + totalMenuPrice + ", price="
				+ price + "]";
	}

}
