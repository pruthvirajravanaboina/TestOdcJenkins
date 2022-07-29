package com.odc.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odc.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,String> {
	
	
	
	
	
	
//	public Customer addCustomer(Customer customer);
//	public Customer removeCustomer(long custId);
//	public Customer updateCustomer(long custId, Customer customer);
//	public Customer getCustomer(long custId);
//	public List<Customer> getAllCustomers(); 
	

}
