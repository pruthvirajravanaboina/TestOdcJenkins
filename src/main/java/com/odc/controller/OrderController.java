package com.odc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.model.Order;
import com.odc.service.IOrderService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/v1/")
public class OrderController {

	@Autowired
	private IOrderService orderservice;

	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order orders) {
		Order order1 = null;
		order1 = this.orderservice.addOrder(orders);
		return order1;
	}

	@GetMapping("/orders/{id}")
	public Order getOrderDetails(@PathVariable("id") long id) {
		Order order = this.orderservice.getOrderDetails(id);
		return order;
	}

	@DeleteMapping("/orders/{id}")
	public Order removeOrder(@PathVariable("id") long id) {
		Order order = this.orderservice.removeOrder(id);
		return order;
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		List<Order> orders = this.orderservice.getAllOrders();
		return orders;
	}

	@PutMapping("/orders/{id}")
	public Order updateOrder(@RequestBody Order orders) {
		Order order2 = this.orderservice.updateOrder(orders);
		return order2;
	}

}
//http://localhost:8082/v1/orders