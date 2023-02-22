package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Controller {
	
	@RequestMapping(value = "/app",method = RequestMethod.GET)
	public String tesing() {
		return "Hello Sai! It is working $@! :)";
	}

}
