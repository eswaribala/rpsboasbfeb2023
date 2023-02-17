package com.boa.customerapikafka.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerFacade {
	
	String outChannel="customer-out";
	
	@Output(outChannel)
	MessageChannel customerPublishChannel();

}
