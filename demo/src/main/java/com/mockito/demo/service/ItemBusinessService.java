package com.mockito.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockito.demo.dao.ItemRepository;
import com.mockito.demo.domain.Item;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item getItems() {
		return new Item(1, "Ball", 200, 3);
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		for(Item item: items)
		{
			item.setValue(item.getPrice()* item.getQuantity());;
		}
		return items;
	}

}
