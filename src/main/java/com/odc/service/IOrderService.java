package com.odc.service;

import java.util.List;

import com.odc.model.Order;

public interface IOrderService {
	public Order addOrder(Order order);

	public Order removeOrder(long id);

	public Order updateOrder(Order order);

	public Order getOrderDetails(long id);

	public List<Order> getAllOrders();

}
