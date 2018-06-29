package com.logicq.wify.helper;

import java.security.SecureRandom;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.wify.model.OrderDetails;
import com.logicq.wify.vo.OrderDetailsVO;

@Component
public class ResturantHelper {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	ObjectMapper mapperObj = new ObjectMapper();

	public String generateOrderId() {
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public OrderDetails convertOrderDetailsVOToOrderDetails(OrderDetailsVO ordervo) throws JsonProcessingException {
		OrderDetails orderDetails = new OrderDetails();
		if (!StringUtils.isEmpty(ordervo.getDescription()))
	    orderDetails.setDescription(ordervo.getDescription());
		orderDetails.setMobileNo(ordervo.getMobileNo());
		orderDetails.setUserName(ordervo.getUserName());
		orderDetails.setTableName(ordervo.getTableName());
		orderDetails.setTotalPrice(ordervo.getTotalPrice());
		orderDetails.setOrderStatus(ordervo.getOrderStatus());
		orderDetails.setOrderId(generateOrderId());
		if (null == ordervo.getOrderTime()) {
			orderDetails.setOrderTime(new Date());
		} else {
			orderDetails.setOrderTime(ordervo.getOrderTime());
		}
		if (null != ordervo.getMenuDetails() && !ordervo.getMenuDetails().isEmpty()) {
			orderDetails.setMenuDetails(mapperObj.writeValueAsBytes(ordervo.getMenuDetails()));
		}
		return orderDetails;
	}

}
