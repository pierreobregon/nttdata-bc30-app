package com.nttdata.bc30.appbc30.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bc30.appbc30.models.documents.ProductType;
import com.nttdata.bc30.appbc30.services.IProductTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/1.0.0/producttypes")
public class ProductTypeController {
	
	@Autowired
	private IProductTypeService service;
	
	@GetMapping
	public ResponseEntity<Flux<ProductType>> findAll(){
		Flux<ProductType> productTypes = service.findAll();
		return new ResponseEntity<Flux<ProductType>>(productTypes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<ProductType>> fintById(@PathVariable("id") String id){
		Mono<ProductType> productType = service.findById(id);
		return new ResponseEntity<Mono<ProductType>>(productType, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Mono<ProductType>> insert(@RequestBody ProductType obj){
		Mono<ProductType> productType = service.insert(obj);
		return new ResponseEntity<Mono<ProductType>>(productType, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Mono<ProductType>> update(@RequestBody ProductType obj){
		Mono<ProductType> productType = service.update(obj);
		return new ResponseEntity<Mono<ProductType>>(productType, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
