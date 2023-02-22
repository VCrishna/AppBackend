package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Constants;
import com.service.ApplicationServiceImpl;

@RestController
@RequestMapping(value = "/")
public class ApplicationController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationController.class);
		
	@Autowired
	ApplicationServiceImpl service;
	
	@RequestMapping(value = Constants.getDataStructureAPI, method = RequestMethod.GET)
	public String getDataStructureController() {
		service.getDataStructures().forEach(x->System.out.println(x.getId()+" "+x.getName()));
		LOGGER.info("getDataStructureController() Successful!");
		return "Hello Sai! It is working $@! :)";
	}

}
