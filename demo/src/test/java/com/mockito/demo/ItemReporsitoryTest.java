package com.mockito.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mockito.demo.dao.ItemRepository;
import com.mockito.demo.domain.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemReporsitoryTest {

	@Autowired
	private ItemRepository repository;
	
	@Test
	private void testFindAll() {
		List<Item> items = repository.findAll();
		assertEquals(3, items.size());
	}
}
