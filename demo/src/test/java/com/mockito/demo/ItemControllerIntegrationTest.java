package com.mockito.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ItemControllerIntegrationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	@Test
	public void contextLoads() {

		String response = this.testRestTemplate.getForObject("/items-from-db", String.class);
	}

}
