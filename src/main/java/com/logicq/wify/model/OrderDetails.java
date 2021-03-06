package com.logicq.wify.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	@Id
	@Column(name = "ORDER_ID", nullable = false)
	private String orderId;

	@Column(name = "TOTAL_PRICE", nullable = false)
	private Double totalPrice;

	@Column(name = "OFFER_PRICE")
	private Double offerPrice;

	@Column(name = "PAYMENT_TYPE")
	private String paymentType;

	@Column(name = "ORDER_TIME", nullable = false)
	private Date orderTime;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TABLE_NO", nullable = false)
	private Integer tableName;

	@Column(name = "STATUS", nullable = false)
	private String orderStatus;

	@Column(name = "MOBILE_NO", nullable = false)
	private String mobileNo;

	@Column(name = "USER_NAME", nullable = false)
	private String userName;

	@Lob
	@Column(name = "MENU_DETAILS")
	private byte[] menuDetails;

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

	public byte[] getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(byte[] menuDetails) {
		this.menuDetails = menuDetails;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", totalPrice=" + totalPrice + ", offerPrice=" + offerPrice
				+ ", paymentType=" + paymentType + ", orderTime=" + orderTime + ", description=" + description
				+ ", tableName=" + tableName + ", orderStatus=" + orderStatus + ", mobileNo=" + mobileNo + ", userName="
				+ userName + ", menuDetails=" + Arrays.toString(menuDetails) + "]";
	}

	
	

}
