package com.boa.transactionapi.controllers;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.transactionapi.services.IndividualService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/individuals")
@Slf4j

public class IndividualController {
    @Autowired
	private IndividualService individualService;
  
  
    
}
