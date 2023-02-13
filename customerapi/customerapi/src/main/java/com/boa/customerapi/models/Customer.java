package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	private long customerId;
	@Embedded
    private FullName name;
	@Column(name="Contact_No")
    private long contactNo;
	@Column(name="Email")
    private String email;
	@Column(name="Password", length = 8)
    private String password;
	

}
