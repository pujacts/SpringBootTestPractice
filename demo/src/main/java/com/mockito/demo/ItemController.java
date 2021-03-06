package com.mockito.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.mockito.demo.domain.Item;
import com.mockito.demo.service.ItemBusinessService;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService service;;
	@GetMapping("/item")
	public Item getItem(){
		return new Item(1, "Ball", 200, 3);
	}
	
	@GetMapping("/item-for-business")
	public Item getItemForBusiness(){
		return service.getItems();
	}
	
	@GetMapping("/items-from-db")
	public List<Item> getAllItem(){
		
		return service.retrieveAllItems();
	}
	
	
	
	
}
