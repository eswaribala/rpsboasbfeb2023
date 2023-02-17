package com.boa.customerapi.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/individuals")
@Slf4j

public class IndividualController {
    @Autowired
	private IndividualService individualService;
  
  
    @PostMapping({"/v1.0/"})
    @CrossOrigin("*")
    public ResponseEntity<?> publishIndividual(@RequestBody Individual individual){
    
    	
    	if(this.individualService.publishCustomer(individual)) 
    		return ResponseEntity.status(HttpStatus.CREATED).body("Message Published....");
    	
    	else
    	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Individual "
    	 		+ "message not published");	
    	
    }
    
}
