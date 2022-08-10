package com.nttdata.bc30.appbc30.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Document(collection="products")
public class Product {

	@Id
	private String id;
	private ProductType productType;// Activo, Pasivo
	private String name;//Ahorro, Cuenta Corriente, Prestamo Personal, Tarjeta Credito
	
	
	
}
