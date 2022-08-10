package com.nttdata.bc30.appbc30.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bc30.appbc30.exceptions.ModelNotFoundException;
import com.nttdata.bc30.appbc30.models.documents.Product;
import com.nttdata.bc30.appbc30.models.repository.IProductRepository;
import com.nttdata.bc30.appbc30.services.IProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repo;
	
	@Override
	public Mono<Product> insert(Product obj) {
		return repo.save(obj);
	}

	@Override
	public Mono<Product> update(Product obj) {
		return repo.save(obj);
	}

	@Override
	public Flux<Product> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Product> findById(String id) {
		return repo.findById(id)
				.switchIfEmpty(Mono.error(() -> new ModelNotFoundException("PRODUCTO NO ENCONTRADO")));
	}

	@Override
	public Mono<Void> delete(String id) {
		return repo.deleteById(id);
	}

}
