package com.boa.customerapi.services;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.customerapi.facades.CustomerMessage;
import com.boa.customerapi.models.Individual;


@Service
public class IndividualService {
  
	@Autowired
    private CustomerMessage customerMessage;
   
    
  public boolean publishCustomer(Individual individual) {
		
		MessageChannel messageChannel=customerMessage.customerPublish();
		if(individual.getDob().isBefore(LocalDate.now())) {
		return messageChannel.send(MessageBuilder
                .withPayload(individual)
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());
		}
		else
		{
			return false;
		}

		
	}

	
}
