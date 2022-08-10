package com.nttdata.bc30.appbc30.models.documents;

import java.math.BigDecimal;

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
@Document(collection="contracts")
public class Contract {

	
	@Id
	private String id;
	private String nroContract;//0001000
	private Customer customer; // cliente, X1 // Empresa SAC EIRL
//	private List<Person> authorizedSignatories; //firmantesAutorizados. C,D
	private Product product; // Pasivos/Activos
	private BigDecimal saldoDisponible;
	private Boolean isActive;
	
//	List<ContractOperations> lstOperaciones; // Operaciones/movimientos - Libro Transacciones - ContractBookTransaccions
	 
	
	 
}

