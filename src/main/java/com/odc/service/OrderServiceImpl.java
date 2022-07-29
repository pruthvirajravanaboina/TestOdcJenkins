package com.odc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.exception.CreationException;
import com.odc.exception.DeletionException;
import com.odc.exception.EmptyListException;
import com.odc.exception.EntityNotFoundException;
import com.odc.exception.UpdationException;
import com.odc.model.Order;
import com.odc.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		try {
			Order order1 = orderRepository.save(order);
			return order1;
		}
		catch(Exception e){
			throw new CreationException("Failed to Create Order.");
		}
		
	}

	@Override
	public Order removeOrder(long id) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		Order order = null;
		if (optionalOrder.isPresent()) {
			order = optionalOrder.get();
			orderRepository.deleteById(id);
			return order;
		}
		else {
			throw new DeletionException("Order With Id " + id + " does not Exist.");
			
		}
		
	}

	@Override
	public Order updateOrder(Order order) {
		Optional<Order> optionalorder = null;
		Order order2 = null;
		optionalorder = orderRepository.findById(order.getOrderId());
		if (optionalorder.isPresent()) {
			order2 = orderRepository.save(order);
			return order2;
		}
		else {
			throw new UpdationException("Order with Id "+order.getOrderId()+" does not exist");
		}
	}

	@Override
	public Order getOrderDetails(long id) {
		Optional<Order> optionalorder = null;
		Order order = null;

		optionalorder = orderRepository.findById(id);
		if (optionalorder.isPresent()) {
			order = optionalorder.get();
			return order;
		}
		else {
			throw new EntityNotFoundException("Order With Id " + id + " does Not Exist.") ;
		}
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> allOrders = new ArrayList<Order>();
		allOrders = orderRepository.findAll();
		if (!allOrders.isEmpty()) {
		return allOrders;
		}
		else {
			throw new EmptyListException("No Orders Found!!!");
		}
	}
}
