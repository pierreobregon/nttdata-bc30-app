package com.nttdata.bc30.appbc30.models.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
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
	
	@Id
	private String id;
	
	private CustomerType customerType; // Personal, Empresarial.
	
//	@DocumentReference(lazy=true)
	private Person person;// DNI/C.Extranj, RUC
	private List<Contract> lstContracts;
	
	
}
