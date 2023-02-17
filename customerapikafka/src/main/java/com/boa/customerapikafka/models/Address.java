package com.boa.customerapikafka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private long addressId;
	
	private String doorNo;
	
	private String streetName;
	
	private String city;
	
	private String state;

	
	private Customer customer;
	
}
