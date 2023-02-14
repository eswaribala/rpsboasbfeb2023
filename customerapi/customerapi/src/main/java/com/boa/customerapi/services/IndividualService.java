package com.boa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepo;

@Service
public class IndividualService {
    @Autowired 
	private IndividualRepo individualRepo;
    
    //insert
    
    public Individual addIndividual(Individual individual) {
    	
    	return this.individualRepo.save(individual);
    }
    
    //all the records
    
    public List<Individual> getAllIndividuals(){
    	return this.individualRepo.findAll();
    }
    
    public Individual getIndividualById(long customerId) {
    	return this.individualRepo.findById(customerId).orElse(null);
    }
    
    public boolean deleteIndividualById(long customerId) {
    	this.individualRepo.deleteById(customerId);
    	if(getIndividualById(customerId)==null)
    		return true;    	
    	else
    		return false;
    	
    }
    
 //update
    
    public Individual updateIndividual(Individual individual) {
    	if(getIndividualById(individual.getCustomerId())!=null)
    	   	
    	  return this.individualRepo.save(individual);
    	else
    		return this.individualRepo.save(individual);
    }
    
    //non primary key
    public List<Individual> findAllByEmailId(String email){
    	return this.individualRepo.findByEmail(email);
    }
	
}
