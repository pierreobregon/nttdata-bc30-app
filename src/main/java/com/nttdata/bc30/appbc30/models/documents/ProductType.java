package com.nttdata.bc30.appbc30.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Document(collection = "productTypes")
public class ProductType {

	@Id
	private String id;
	private String name; //Pasivo, Activo
						
	
	
	
}
