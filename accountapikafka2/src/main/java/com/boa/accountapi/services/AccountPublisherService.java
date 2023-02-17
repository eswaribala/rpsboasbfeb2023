package com.boa.accountapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.accountapi.facades.AccountFacade;
import com.boa.accountapi.models.Individual;
import com.boa.accountapi.repositories.IndividualRepo;

@Service
public class AccountPublisherService {
	@Autowired
	private IndividualRepo individualRepo;
    @Autowired
	private AccountFacade accountFacade;
public boolean publishData(long customerId) {
		
		Individual individual=this.individualRepo.findById(customerId).orElse(null);
		
		MessageChannel messageChannel=accountFacade.accountPublishChannel();
		
		return messageChannel.send(MessageBuilder
                .withPayload(individual)
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());
	}


}
