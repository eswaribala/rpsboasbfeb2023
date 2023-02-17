package com.boa.accountapi.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.accountapi.services.AccountPublisherService;
import com.boa.accountapi.services.IndividualConsumerService;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/individuals")
@Slf4j

public class IndividualController {
    @Autowired
	private AccountPublisherService accountService;
  
    @GetMapping({"/v1.0/{customerId}"})
    @CrossOrigin("*")
    public ResponseEntity<?> publishIndividual(@PathVariable("customerId") long customerId){
    
    	
    	if(this.accountService.publishData(customerId)) 
    		return ResponseEntity.status(HttpStatus.CREATED).body("Message Published....");
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "message not published");	
    	
    }
    
}
