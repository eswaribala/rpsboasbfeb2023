package com.boa.customerapi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Address_Id")
	private long addressId;
	@Column(name="Door_No", length = 5)
	private String doorNo;
	@Column(name="Street_Name")
	private String streetName;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Customer_Id"), name = "Customer_Id")

	private Customer customer;
	
}
