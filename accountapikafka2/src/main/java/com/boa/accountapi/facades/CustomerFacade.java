package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerFacade {
	
	String inChannel="customer-in";
	
	@Input(inChannel)
	MessageChannel customerConsumerChannel();

}
