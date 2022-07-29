package com.odc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.odc.model.Customer;

@Service
public interface ICustomerService {
//	public Customer addCustomer(Customer customer);
//	public Customer removeCustomer(long custId);
//	public Customer updateCustomer(long custId, Customer customer);
//	public Customer getCustomer(long custId);
//	public List<Customer> getAllCustomers(); 
	
	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(String custId);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomer(String custId);
	public List<Customer> getAllCustomers();

}
