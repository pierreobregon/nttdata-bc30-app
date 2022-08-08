package com.nttdata.bc30.models.documents;

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
@Document(collection = "productTypes")
public class ProductType {

	@MongoId
	private String id;
	private String name; //Pasivo, Activo
						
	
	
	
}
