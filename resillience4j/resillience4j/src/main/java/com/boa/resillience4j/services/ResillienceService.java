package com.boa.resillience4j.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResillienceService {

	@Value("${serviceUrl}")
    private String serviceUrl;
    @Value("${alternativeServiceUrl}")
    private String alternativeServiceUrl;
    @Autowired
    private RestTemplate restTemplate;
    

    @CircuitBreaker(name = "gatewayCircuitBreaker", 
    		fallbackMethod = "fallback")
    @Retry(name = "gatewayRetry")

	public String getData(String userName,String userPwd) {

        log.info(" Making a request to " + serviceUrl + " at :"+ LocalDateTime.now());
       
        return restTemplate.getForObject(serviceUrl+"?userName="+userName+"&userPwd="+userPwd, String.class);

	}
	
    public String fallbackGetData(String userName,String userPwd,Exception ex) {
    	log.info(" Making a request to " + alternativeServiceUrl + " at :"+ LocalDateTime.now());
        
        return restTemplate.getForObject(alternativeServiceUrl, String.class);

	}
	
	
}
