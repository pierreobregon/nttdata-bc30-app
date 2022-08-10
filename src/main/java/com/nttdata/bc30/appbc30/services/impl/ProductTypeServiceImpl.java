package com.nttdata.bc30.appbc30.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bc30.appbc30.exceptions.ModelNotFoundException;
import com.nttdata.bc30.appbc30.models.documents.ProductType;
import com.nttdata.bc30.appbc30.models.repository.IProductTypeRepository;
import com.nttdata.bc30.appbc30.services.IProductTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

	@Autowired
	private IProductTypeRepository repo;
	
	@Override
	public Mono<ProductType> insert(ProductType obj) {
		return repo.save(obj);
	}

	@Override
	public Mono<ProductType> update(ProductType obj) {
		return repo.save(obj);
	}

	@Override
	public Flux<ProductType> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<ProductType> findById(String id) {
		return repo.findById(id)
				.switchIfEmpty(Mono.error(() -> new ModelNotFoundException("TIPO PRODUCTO NO ENCONTRADO")));
	}

	@Override
	public Mono<Void> delete(String id) {
		return repo.deleteById(id);
	}

}
