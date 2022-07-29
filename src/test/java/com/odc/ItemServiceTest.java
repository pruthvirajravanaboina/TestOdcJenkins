package com.odc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.odc.model.Item;
import com.odc.repository.ItemRepository;
import com.odc.service.ItemService;

@SpringBootTest
class ItemServiceTest {

	@Autowired
	ItemService itemService;

	@Autowired
	ItemRepository itemrepo;

	Item customer_item;

	/*
	 * @Test void testAddItem() {
	 * 
	 * Item c = new Item(1, "shirt", "blue", "washing", 4, "cotton", "Processing");
	 * Item c2 = itemService.addItem(customer_item); System.out.println(c); }
	 */

	public Item addItem() {
		Item b1 = new Item();
		b1.setItemId(5L);
		b1.setName("shirt");
		b1.setColor("blue");
		b1.setCategory("washing");
		b1.setQuantity(4);
		b1.setMaterial("washing");
		b1.setDescription("processed for washing");
		b1.setCustomer(null);
		return b1;

	}

	@Test
	void testAddItem() {
		Item item = addItem();
		itemrepo.save(item);
		assertThat(item.equals(itemService.addItem(item)));
	}

	@Test
	void testRemoveItem() {
		Item item = addItem();
		itemrepo.save(item);
		itemrepo.findById(5L);
		Item b = itemService.removeItem(5L);
		assertFalse(item.equals(b));
	}

	@Test
	void testUpdateItem() {
		Item item = addItem();
		itemrepo.save(item);
		itemrepo.findById(101L);
		item.setCategory("Drycleaning");
		Item b1 = itemService.getItem(5L);
		itemrepo.save(item);
		assertThat(b1.equals(itemService.updateItem(item)));
	}

	@Test
	void testGetAllItems() {
		Item item = addItem();
		Item item1 = addItem();
		List<Item> list = new ArrayList<Item>();
		list.add(item);
		list.add(item1);
		itemrepo.save(item);
		itemrepo.save(item1);
		List<Item> b = itemService.getAllItems();
		assertThat(list.equals(b));
	}

}
