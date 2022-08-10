package com.nttdata.bc30.appbc30.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bc30.appbc30.models.documents.Customer;
import com.nttdata.bc30.appbc30.models.repository.ICustomerRepository;
import com.nttdata.bc30.appbc30.services.ICustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
//	@Autowired
//	private ICustomerTypeRepository customerTypeRepository;
//	
	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public Mono<Customer> insert(Customer obj) {
		return repo.save(obj);
	}

	@Override
	public Mono<Customer> update(Customer obj) {
		return repo.save(obj);
	}

	@Override
	public Flux<Customer> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Customer> findById(String id) {
		logger.info("findById");
		return repo.findById(id);
//				.switchIfEmpty(Mono.error(() -> new ModelNotFoundException("CLIENTE NO ENCONTRADO")))
//				.doOnNext(c -> logger.info("Termino"));
	}

	@Override
	public Mono<Void> delete(String id) {
		return repo.deleteById(id);
	}

}
