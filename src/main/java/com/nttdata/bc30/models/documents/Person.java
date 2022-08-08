package com.nttdata.bc30.models.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

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

	@MongoId
	private String id;
	private String fullName; // Empresa SAC EIRL
	private String typeDocument;//DNI, RUC
	private String numberDocument;//10254786455
	private String email;
	
	private List<String> personIds;
	
}
