package com.odc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.exception.CreationException;
import com.odc.exception.DeletionException;
import com.odc.exception.EmptyListException;
import com.odc.exception.UpdationException;
import com.odc.model.Item;
import com.odc.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@SuppressWarnings("finally")
	@Override
	public Item addItem(Item item)   {
		// TODO Auto-generated method stub
		Item item1=null;
		Optional<Item> oci= itemRepository.findById((long) item.getItemId());
		try {
			if(!(oci.isPresent())) {
		 item1 = itemRepository.save(item);	 
			
			}
			else {
				throw new CreationException("Failed to create CustomerItem.");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			
	}
		finally {
		return item1;
		}	
	}

	@Override
	public Item removeItem(long id) throws DeletionException  {
		// TODO Auto-generated method stub
		Optional<Item> optionalItem = itemRepository.findById(id);
		Item item = null;
		if (optionalItem.isPresent()) {
			item = optionalItem.get();
			itemRepository.deleteById(id);
		
		}
	else {
		throw new DeletionException("CustomerItem with ID " + id + " Cannot be Found");
		}
		return item;
		
	}

	@Override
	public Item updateItem(Item item) throws UpdationException  {
		// TODO Auto-generated method stub
		Optional<Item> optionalItem = null;
		Item item1 = null;

		optionalItem = itemRepository.findById( item.getItemId());
		try {
			if (optionalItem.isPresent()) {
				item1 = itemRepository.save(item);
				
} else {
			throw new UpdationException("CustomerItem with ID " + item.getItemId() + " Cannot be Updated");

			}
		} catch (UpdationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item1;
	
	
	}

	@Override
	public Item getItem(long id) {
		// TODO Auto-generated method stub
		Item item = null;

		Optional<Item> optionalItem = itemRepository.findById(id);
		
	if (optionalItem.isPresent()) {
			item = optionalItem.get();
		return item;
	} else {
		throw new EntityNotFoundException("Item with ID " + id + " Cannot be Found");
	}
		
	}

	@Override
	public List<Item> getItemsByCustomer(String customerId)    {
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<Item>();
		items = itemRepository.getItemsByCustomer(customerId);
		if (!items.isEmpty()) {
			return items;
	} else {
			throw new EmptyListException("No Items Found For Given Customer Id " + customerId);
		}
	}


	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> allItems = new ArrayList<Item>();
		allItems = itemRepository.findAll();
		if (!allItems.isEmpty()) {
			return allItems;
		} else {
			throw new EntityNotFoundException("No Items Found");
		}
	}

}
