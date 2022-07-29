package com.odc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.model.Customer;
import com.odc.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer customer1 = this.customerService.addCustomer(customer);
		return customer1;
	}

	@DeleteMapping("/delete/{id}")
	public Customer removeCustomer(@PathVariable("id") String custId) {
		Customer customer = this.customerService.removeCustomer(custId);
		return customer;
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer customer1 = this.customerService.updateCustomer(customer);
		return customer1;
	}

	@GetMapping("/view/{id}")
	public Customer getCustomer(@PathVariable("id") String custId) {
		Customer customer = this.customerService.getCustomer(custId);
		return customer;
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomer() {
		List<Customer> customers = this.customerService.getAllCustomers();
		return customers;
	}

}
