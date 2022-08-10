package com.nttdata.bc30.appbc30.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bc30.appbc30.exceptions.ModelNotFoundException;
import com.nttdata.bc30.appbc30.models.documents.CustomerType;
import com.nttdata.bc30.appbc30.models.repository.ICustomerTypeRepository;
import com.nttdata.bc30.appbc30.services.ICustomerTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

	@Autowired
	private ICustomerTypeRepository repo;
	
	@Override
	public Mono<CustomerType> insert(CustomerType obj) {
		return repo.save(obj);
	}

	@Override
	public Mono<CustomerType> update(CustomerType obj) {
		return repo.save(obj);
	}

	@Override
	public Flux<CustomerType> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<CustomerType> findById(String id) {
		return repo.findById(id)
				.switchIfEmpty(Mono.error(() -> new ModelNotFoundException("TIPO CLIENTE NO ENCONTRADO")));
	}

	@Override
	public Mono<Void> delete(String id) {
		return repo.deleteById(id);
	}

}
