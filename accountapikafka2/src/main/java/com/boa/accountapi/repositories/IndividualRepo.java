package com.boa.accountapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.accountapi.models.Individual;

public interface IndividualRepo extends MongoRepository<Individual, Long>{

}
