package com.boa.customerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boa.customerapi.models.Individual;

public interface IndividualRepo extends JpaRepository<Individual, Long>{

	@Query("Select i from Individual i where i.email=:email")
	public List<Individual> findByEmail(@Param("email") String email);
	
}
