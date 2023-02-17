package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AccountFacade {
String outChannel="account-out";
	
	@Output(outChannel)
	MessageChannel accountPublishChannel();

}
