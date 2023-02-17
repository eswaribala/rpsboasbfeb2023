package com.boa.accountapi.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("customers")
public class Customer {
	@Id
	private long customerId;

    private FullName name;

    private long contactNo;

    private String email;

    private String password;
	

}
