package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ApplicationDAOImpl;
import com.model.DataStructures;


@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationServiceImpl.class);
	
	@Autowired
	ApplicationDAOImpl DAO;


	@Override
	public List<DataStructures> getDataStructures() {
		LOGGER.info("getDataStructure Service Successful!");
		return DAO.getDataStructures();
	}



}
