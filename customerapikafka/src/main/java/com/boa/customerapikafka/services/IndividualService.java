package com.boa.customerapikafka.services;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import com.boa.customerapikafka.facades.CustomerFacade;
import com.boa.customerapikafka.models.Individual;


@Service
public class IndividualService {
  
	@Autowired
    private CustomerFacade customerFacade;
   
    
  public boolean publishCustomer(Individual individual) {
		
		MessageChannel messageChannel=customerFacade.customerPublishChannel();
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
