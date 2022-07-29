package com.odc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.odc.exception.CreationException;
import com.odc.exception.DeletionException;
import com.odc.exception.EmptyListException;
import com.odc.exception.EntityNotFoundException;
import com.odc.exception.UpdationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.model.Customer;
import com.odc.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer customer1 = null;
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getUserId());
		if (optionalCustomer.isEmpty()) {
			customer1 = customerRepository.save(customer);
			return customer1;
		} else {
			throw new CreationException("Customer Already Exixts !");
		}
	}

	@Override
	public Customer removeCustomer(String custId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(custId);
		Customer customer = null;
		if (optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
			customerRepository.deleteById(custId);
			return customer;
		} else {
			throw new DeletionException("Exception Occured while Removing !");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalCustomer = null;
		Customer customer1 = null;
		optionalCustomer = customerRepository.findById(customer.getUserId());
		if (optionalCustomer.isPresent()) {
			customer1 = customerRepository.save(customer);
			return customer1;
		} else {
			throw new UpdationException("Error occured while Updating!");
		}
	}

	@Override
	public Customer getCustomer(String custId) {
		Optional<Customer> optionalCustomer = null;
		Customer customer = null;
		optionalCustomer = customerRepository.findById(custId);
		if (optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
			return customer;
		} else {
			throw new EntityNotFoundException("Customer Not Found !");
		}

	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomer = new ArrayList<Customer>();
		allCustomer = customerRepository.findAll();
		if (!allCustomer.isEmpty()) {
			return allCustomer;
		} else {
			throw new EmptyListException("No Customer Found !");
		}
	}

}
