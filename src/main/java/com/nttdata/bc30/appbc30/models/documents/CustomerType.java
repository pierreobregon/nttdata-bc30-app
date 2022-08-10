package com.nttdata.bc30.appbc30.models.documents;

import java.io.Serializable;

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
@Document(collection = "customertypes")
public class CustomerType implements Serializable{

	@Id
	private String id;
	private String name;// Personal, Empresarial.
	private String description;
	
	
	
}
