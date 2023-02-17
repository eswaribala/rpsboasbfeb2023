package com.boa.resillience4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boa.resillience4j.services.ResillienceService;
import com.boa.resillience4j.vos.JwtRequest;

@RestController
public class CBController {
    @Autowired
	private ResillienceService service;
    
    @PostMapping("/")
    public String getData(@RequestBody JwtRequest jwtRequest) {
    
    	return this.service.getData(jwtRequest);
    }
	
}
