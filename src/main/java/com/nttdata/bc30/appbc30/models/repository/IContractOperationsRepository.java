package com.nttdata.bc30.appbc30.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bc30.appbc30.models.documents.ContractOperations;

public interface IContractOperationsRepository extends ReactiveMongoRepository<ContractOperations, String>{
	
}
