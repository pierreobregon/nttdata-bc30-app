package com.nttdata.bc30.models.documents;

import java.math.BigDecimal;
import java.util.Date;

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
@Document(collection="contractOperations")
public class ContractOperations {

	@MongoId
	private String id;
	private Integer movementNumber;//Autogenerado
	private String channel;//ATM, Oficina, App, web, telefonico.
	private String typeOperation; //Transferencia, Retiro, Pago Interes, Pago Deuda, Pago TCredito, Pago Servicio.
	private String commentCustomer;// "Page rappi", "page luz".
	private BigDecimal amount; // monto de movimiento.
	private Date createAt; //Fecha Movimiento.
	
	
	
}
