package com.boa.customerapi.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerMessage {
	
	String outChannel="customer-out";
	
     @Output(outChannel)
	 MessageChannel customerPublish();
	
}
