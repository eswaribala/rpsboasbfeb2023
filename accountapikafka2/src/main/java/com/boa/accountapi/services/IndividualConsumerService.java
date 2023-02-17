package com.boa.accountapi.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.boa.accountapi.facades.CustomerFacade;
import com.boa.accountapi.models.Individual;
import com.boa.accountapi.repositories.IndividualRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class IndividualConsumerService {
   @Autowired
	private IndividualRepo individualRepo;
    
	private ObjectMapper objectMapper;
	private Individual individual;
	@StreamListener(target = CustomerFacade.inChannel)
	public void consumeCustomerData(String message) {
		
	 log.info("Customer Data Received"+message);

	 objectMapper=new ObjectMapper();
	 try {
		individual=objectMapper.readValue(message,Individual.class);
		log.info("Java Object"+individual);
		this.individualRepo.save(individual);
		
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
	}

    
	
}
