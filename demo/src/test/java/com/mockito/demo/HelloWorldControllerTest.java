package com.mockito.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)
@RunWith(SpringRunner.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldTest() throws Exception {
		// call hello-world Get Application json
		RequestBuilder request = MockMvcRequestBuilders.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("hey dere, I hope you are okay:)"))
				.andReturn();

		// verify hello-world
		assertEquals("hey dere, I hope you are okay:)", result.getResponse().getContentAsString());
	}
}
