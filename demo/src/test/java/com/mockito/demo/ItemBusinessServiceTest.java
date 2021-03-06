package com.mockito.demo;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.mockito.demo.dao.ItemRepository;
import com.mockito.demo.domain.Item;
import com.mockito.demo.service.ItemBusinessService;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@Mock
	private ItemRepository repo;
	
	@InjectMocks
	private ItemBusinessService service;
	
	@Test
	public void getAllItems(){
		when(repo.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2", 10, 10)));
		List<Item> items = service.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
	}
}
