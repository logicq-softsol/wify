package com.logicq.wify.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.wify.helper.ResturantHelper;
import com.logicq.wify.model.Menu;
import com.logicq.wify.model.OrderDetails;
import com.logicq.wify.model.ResturantMenuTypes;
import com.logicq.wify.repo.MenuRepository;
import com.logicq.wify.repo.MenuTypeRepository;
import com.logicq.wify.repo.OrderRepository;
import com.logicq.wify.vo.OrderDetailsVO;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/admin/resturant")
public class ResturantDetailsController {

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	MenuTypeRepository menuTypeRepository;

	@Autowired
	ResturantHelper resturantHelper;

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@RequestMapping(value = "/menu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> createMenu(@RequestBody Menu menu) {
		menuRepository.save(menu);
		return new ResponseEntity<List<Menu>>(menuRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> createMenus(@RequestBody List<Menu> menus) {
		menuRepository.save(menus);
		return new ResponseEntity<List<Menu>>(menuRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menus", method = RequestMethod.DELETE)
	public ResponseEntity<List<Menu>> deleteMenus(@RequestBody List<Menu> menus) {
		menuRepository.delete(menus);
		return new ResponseEntity<List<Menu>>(menuRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menus/{menuId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Menu>> deleteMenus(@PathVariable Long menuId) {
		menuRepository.delete(menuId);
		return new ResponseEntity<List<Menu>>(menuRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menus", method = RequestMethod.GET)
	public ResponseEntity<List<Menu>> findAllMenus() {
		return new ResponseEntity<List<Menu>>(menuRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menuTypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ResturantMenuTypes>> createMenuTypes(@RequestBody List<ResturantMenuTypes> menuTypes) {
		menuTypeRepository.save(menuTypes);
		return new ResponseEntity<List<ResturantMenuTypes>>(menuTypeRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menuTypes", method = RequestMethod.DELETE)
	public ResponseEntity<List<ResturantMenuTypes>> deleteMenuTypes(@RequestBody List<ResturantMenuTypes> menuTypes) {
		menuTypeRepository.delete(menuTypes);
		return new ResponseEntity<List<ResturantMenuTypes>>(menuTypeRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/menuTypes", method = RequestMethod.GET)
	public ResponseEntity<List<ResturantMenuTypes>> findAllMenuTypes() {
		return new ResponseEntity<List<ResturantMenuTypes>>(menuTypeRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDetails>> placeOrder(@RequestBody OrderDetails orderDetails) {
		orderRepository.save(orderDetails);
		return new ResponseEntity<List<OrderDetails>>(orderRepository.findTop20ByOrderByOrderTimeDesc(), HttpStatus.OK);
	}

	@RequestMapping(value = "/order", method = RequestMethod.DELETE)
	public ResponseEntity<List<OrderDetails>> deleteOrder(@RequestBody OrderDetails orderDetails) {
		orderRepository.delete(orderDetails);
		return new ResponseEntity<List<OrderDetails>>(orderRepository.findTop20ByOrderByOrderTimeDesc(), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDetails>> findAllOrder() {
		return new ResponseEntity<List<OrderDetails>>(orderRepository.findTop20ByOrderByOrderTimeDesc(), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDetails>> findAllOrderAccordingStatus(@PathVariable String status) {
		return new ResponseEntity<List<OrderDetails>>(orderRepository.findTop20ByOrderByOrderStatus(status),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/menus/{avltype}", method = RequestMethod.GET)
	public ResponseEntity<List<Menu>> findMenusAccoringToAvalType(@PathVariable String avltype) {
		return new ResponseEntity<List<Menu>>(menuRepository.findByAvlType(avltype), HttpStatus.OK);
	}

	@RequestMapping(value = "/placedOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDetailsVO> placeOrderForUser(@RequestBody OrderDetailsVO orderDetailsVO)
			throws Exception {
		if (null != orderDetailsVO) {
			OrderDetails orderDetails = resturantHelper.convertOrderDetailsVOToOrderDetails(orderDetailsVO);
			orderRepository.save(orderDetails);
		
			List<OrderDetails> orderList = orderRepository.findByOrderStatusNot("PAID");
			orderList.forEach(ord -> {
				ord.setMenuDetails(null);
			});
			brokerMessagingTemplate.convertAndSend("/topics/orderPlaced", orderList);
		}

		return new ResponseEntity<OrderDetailsVO>(orderDetailsVO, HttpStatus.OK);
	}

	@RequestMapping(value = "/orderStatus", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDetails>> updateOrderForUser(@RequestBody OrderDetails orderDetails) {
		if (null != orderDetails) {
			orderRepository.save(orderDetails);
		}
		return new ResponseEntity<List<OrderDetails>>(orderRepository.findByTableName(orderDetails.getTableName()),
				HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/ordersExceptStatus/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDetails>> findAllOrderExceptStatus(@PathVariable String status) {
		return new ResponseEntity<List<OrderDetails>>(orderRepository.findByOrderStatusNot(status),
				HttpStatus.OK);
	}

}
