package com.boa.accountapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(CustomerFacade.class)
public class StreamInConfig {

}
