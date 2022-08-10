package com.nttdata.bc30.appbc30.models.documents;

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
@Document(collection="persons")
public class Person {

	@Id
	private String id;
	private String fullName; // Empresa SAC EIRL
	private String typeDocument;//DNI, RUC
	private String numberDocument;//10254786455
	private String email;
	
//	private List<String> personIds;
	
}
