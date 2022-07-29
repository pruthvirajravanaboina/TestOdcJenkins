package com.odc.service;

import java.util.List;

import com.odc.exception.DeletionException;
import com.odc.exception.UpdationException;
import com.odc.model.Item;

public interface ItemService {
	
	public Item addItem(Item item) ;
	public Item removeItem(long id) throws DeletionException  ;
	public Item updateItem(Item item) throws UpdationException ;
	public Item getItem(long id);
	public List<Item> getItemsByCustomer(String customerId)  ;
	public List<Item> getAllItems();

}
