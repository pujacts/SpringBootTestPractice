package com.mockito.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mockito.demo.domain.Item;
import com.mockito.demo.service.ItemBusinessService;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService service;
	
	@Test
	public void getItem() throws Exception {
		// call hello-world Get Application json
		RequestBuilder request = MockMvcRequestBuilders.get("/item")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":200,\"quantity\":3}"))
				.andReturn();

	}
	

	@Test
	public void itemFromBusiness() throws Exception {
		// call hello-world Get Application json
		when(service.getItems()).thenReturn(new Item(2,"Item2", 10, 10));
		RequestBuilder request = MockMvcRequestBuilders.get("/item-for-business")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10}"))
				.andReturn();

	}
	
	@Test
	public void itemFromDatabase() throws Exception {
		// call hello-world Get Application json
		when(service.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(2,"Item2", 10, 10))
				);
		RequestBuilder request = MockMvcRequestBuilders.get("/items-from-db")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:Item2,price:10}]"))
				.andReturn();

	}
}
