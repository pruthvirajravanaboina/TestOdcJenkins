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

import com.odc.model.Item;
import com.odc.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/add")
	public Item addItem(@RequestBody Item item)  {
		Item item2 = this.itemService.addItem(item);
		return item2;
	}
	
	@DeleteMapping("/delete/{id}")
	public Item removeItem(@PathVariable long id)  {
		Item item = null;
		
			item = this.itemService.removeItem(id);
		return item;
	}

	@PutMapping("/update")
	public Item updateItem(@RequestBody Item item)  {
		Item item2 = null;
	
			item2 = this.itemService.updateItem( item);
		
			// TODO Auto-generated catch block
			
		
		return item2;
	}
	
	@GetMapping("/view/{id}")
	public Item getItem(@PathVariable long id) {
		Item item = this.itemService.getItem(id);
		return item;
	}
	
	@GetMapping("/getByCustomer/{id}")
	public List<Item> getItemsByCustomer(@PathVariable("id") String customerId) {
		List<Item> items = null;
		
			items = this.itemService.getItemsByCustomer(customerId);
		
		return items;
	}

	@GetMapping("/all")	
	public List<Item> getAllItems() {
		List<Item> items = this.itemService.getAllItems();
		return items;
	}
}
	
