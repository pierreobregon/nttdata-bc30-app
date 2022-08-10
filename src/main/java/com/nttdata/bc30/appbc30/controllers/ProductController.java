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

import com.nttdata.bc30.appbc30.models.documents.Product;
import com.nttdata.bc30.appbc30.services.IProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/1.0.0/products")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping
	public ResponseEntity<Flux<Product>> findAll(){
		Flux<Product> products = service.findAll();
		return new ResponseEntity<Flux<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Product>> fintById(@PathVariable("id") String id){
		Mono<Product> product = service.findById(id);
		return new ResponseEntity<Mono<Product>>(product, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Mono<Product>> insert(@RequestBody Product obj){
		Mono<Product> product = service.insert(obj);
		return new ResponseEntity<Mono<Product>>(product, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Mono<Product>> update(@RequestBody Product obj){
		Mono<Product> product = service.update(obj);
		return new ResponseEntity<Mono<Product>>(product, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
