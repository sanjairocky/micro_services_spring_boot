package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/greeting")
	public String hi(@RequestParam(value = "name", defaultValue = "Service2") String name) {

		return name;
	}
}
