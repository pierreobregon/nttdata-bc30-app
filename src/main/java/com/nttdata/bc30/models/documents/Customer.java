package com.nttdata.bc30.models.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="customers")
public class Customer {
	
	private CustomerType customerType; // Personal, Empresarial.
	private Person person;// DNI/C.Extranj, RUC
	private List<Contract> lstContracts;
	
	
}
