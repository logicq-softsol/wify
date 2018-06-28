package com.logicq.wify.vo;

import java.util.Date;
import java.util.List;

public class OrderDetailsVO {

	private String orderId;
	private Double totalPrice;
	private Double offerPrice;
	private String paymentType;
	private Date orderTime;
	private String description;
	private Integer tableName;
	private String orderStatus;
	private String mobileNo;
	private String userName;
	private List<MenuVO> menuDetails;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTableName() {
		return tableName;
	}

	public void setTableName(Integer tableName) {
		this.tableName = tableName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<MenuVO> getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(List<MenuVO> menuDetails) {
		this.menuDetails = menuDetails;
	}

	@Override
	public String toString() {
		return "OrderDetailsVO [orderId=" + orderId + ", totalPrice=" + totalPrice + ", offerPrice=" + offerPrice
				+ ", paymentType=" + paymentType + ", orderTime=" + orderTime + ", description=" + description
				+ ", tableName=" + tableName + ", orderStatus=" + orderStatus + ", mobileNo=" + mobileNo + ", userName="
				+ userName + ", menuDetails=" + menuDetails + "]";
	}

	

}
