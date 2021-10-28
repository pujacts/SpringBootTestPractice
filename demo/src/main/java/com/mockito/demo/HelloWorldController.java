package com.mockito.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloworld(){
		return "hey dere, I hope you are okay:)";
	}
}
