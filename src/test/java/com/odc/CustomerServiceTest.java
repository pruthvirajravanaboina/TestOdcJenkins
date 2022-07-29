package com.odc;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.odc.model.Address;
import com.odc.model.Customer;
import com.odc.repository.ICustomerRepository;
import com.odc.service.ICustomerService;

@SpringBootTest
class CustomerServiceTest {
	@Autowired
	ICustomerService iCustomerService;
	@Autowired
	ICustomerRepository iCustomerRepository;

	public Customer customerTest1() {
		Address address = new Address("45", "Haltu Main Road", "Haltu", "Kolkata", "West Bengal", 700056);
		Customer customer = new Customer("ABC452", "Java", "corejava@email.com", "7894561230", LocalDate.now(),
				address);
		return customer;
	}

	public Customer customerTest2() {
		Address address = new Address("74L", "Inders Road", "Indira Garden", "New Delhi", "Delhi", 700036);
		Customer customer = new Customer("ABC452", "DBMS", "rdbms@email.com", "4582661230", LocalDate.now(), address);
		return customer;
	}

	@Test
	void testAddCustomer() {
		Customer customer1 = iCustomerService.addCustomer(customerTest1());
		Optional<Customer> customerOp = iCustomerRepository.findById(customerTest1().getUserId());
		Customer customer2 = customerOp.get();
		assertThat(customer1.equals(customer2));
	}

	@Test
	void testRemoveCustomer() {
		Customer customer1 = customerTest1();
		assertThat(iCustomerService.removeCustomer(customer1.getUserId()) == null);
	}

	@Test
	void testUpdateCustomer() {
		Customer customer1 = iCustomerRepository.save(customerTest1());
		Customer customer2 = iCustomerService.updateCustomer(customerTest2());
		assertThat(customer1.getUserId().equals(customer2.getUserId()));
	}

	@Test
	void testGetCustomer() {
		Customer customer1 = customerTest1();
		Customer customer2 = iCustomerService.getCustomer(customer1.getUserId());
		assertThat(customer1.equals(customer2));
	}

	@Test
	void testGetAllCustomers() {
		List<Customer> cList = new ArrayList<>();
		cList.add(customerTest1());
		cList.add(customerTest2());
		iCustomerRepository.save(customerTest1());
		iCustomerRepository.save(customerTest2());
		assertThat(cList.equals(iCustomerService.getAllCustomers()));

	}

}
