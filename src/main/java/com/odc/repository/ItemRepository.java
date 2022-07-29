package com.odc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.odc.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

	//List<Item> getItemsByCustomer(long customerId);
	
	@Query(value = "SELECT item FROM Item item WHERE item.customer.userId=:customerId")
	List<Item> getItemsByCustomer(@Param(value = "customerId") String customerId);

}

