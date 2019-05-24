package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	@Autowired
	RestTemplate restTemplate;

	
	
	@RequestMapping("/user")
	public String hi(@RequestParam(value = "name", defaultValue = "Service1") String name) {

		
		// TODO: Wrap this with Hystrix
		// =====================================
		final String greeting = this.restTemplate.getForObject("http://service2/greeting", String.class);
		// =====================================

		return String.format("%s, %s!", greeting, name);
	}
}
