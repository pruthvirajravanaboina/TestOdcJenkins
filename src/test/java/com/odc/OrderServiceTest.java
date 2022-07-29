package com.odc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.odc.model.Order;
import com.odc.repository.IOrderRepository;
import com.odc.service.IOrderService;

@SpringBootTest
class OrderServiceTest {

	@Autowired
	IOrderService orderservice;

	@Autowired
	IOrderRepository orderRepository;

	public Order orderTest() {
		Order order = new Order();
		order.setOrderId(123L);
		order.setAmount(999.0);
		order.setBillingDate(LocalDate.now());
		order.setPaymentMethod("UPI");
		order.setBookingDetails(null);
		order.setCustomer(null);
		return order;

	}

	public Order orderTest1() {
		Order order1 = new Order();
		order1.setOrderId(345L);
		order1.setAmount(777.0);
		order1.setBillingDate(LocalDate.now());
		order1.setPaymentMethod("Card");
		order1.setBookingDetails(null);
		order1.setCustomer(null);
		return order1;

	}

	@Test
	void testaddOrder() {
		Order ordered = orderTest();
		orderRepository.save(ordered);
		assertThat(ordered.equals(orderservice.addOrder(ordered)));

	}

	@Test
	void testRemoveOrder() {
		Order ordered = orderTest();
		orderRepository.save(ordered);
		orderRepository.findById(123L);
		Order Or = orderservice.removeOrder(123L);
		assertFalse(ordered.equals(Or));
	}

	@Test
	void testUpdateOrder() {
		Order ordered = orderTest();
		orderRepository.save(ordered);
		orderRepository.findById(123L);
		ordered.setPaymentMethod("NEFT");
		Order Or = orderservice.getOrderDetails(123L);
		orderRepository.save(ordered);
		assertThat(Or.equals(orderservice.updateOrder(ordered)));

	}

	@Test
	void testGetAllOrders() {
		Order ordered = orderTest();
		Order ordered1 = orderTest1();

		List<Order> OrderList = new ArrayList<>();
		OrderList.add(ordered);
		OrderList.add(ordered1);
		orderRepository.save(ordered);
		orderRepository.save(ordered1);
		assertThat(OrderList.equals(orderservice.getAllOrders()));

	}

}
