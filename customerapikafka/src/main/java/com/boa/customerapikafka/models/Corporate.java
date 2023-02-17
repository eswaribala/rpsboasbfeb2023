package com.boa.customerapikafka.models;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corporate extends Customer{
   
	private CompanyType companyType;
}
