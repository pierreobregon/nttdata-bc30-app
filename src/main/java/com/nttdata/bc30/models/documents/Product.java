package com.nttdata.bc30.models.documents;

import java.math.BigDecimal;

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
@Document(collection="products")
public class Product {

	@MongoId
	private String id;
	private ProductType productType;// Activo, Pasivo
	private String name;//Ahorro, Cuenta Corriente, Prestamo Personal, Tarjeta Credito
	
	
	
}
