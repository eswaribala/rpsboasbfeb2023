package com.boa.customerapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(CustomerMessage.class)
public interface CustomerStream {

}
