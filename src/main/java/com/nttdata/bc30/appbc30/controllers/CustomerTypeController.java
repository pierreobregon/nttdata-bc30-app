package com.nttdata.bc30.appbc30.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.nttdata.bc30.appbc30.models.documents.CustomerType;
import com.nttdata.bc30.appbc30.services.ICustomerTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/1.0.0/customertypes")
public class CustomerTypeController {

	private static final Logger log = LoggerFactory.getLogger(CustomerTypeController.class);
	
	@Autowired
	private ICustomerTypeService service;

    @GetMapping
    public ResponseEntity<Flux<CustomerType>> findAll(){
    	
    	log.info("CustomerTypeController.findAll");
        Flux<CustomerType> customerTypes = service.findAll();
        
        return new ResponseEntity<Flux<CustomerType>>(customerTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<CustomerType>> fintById(@PathVariable("id") String id){
    	log.info("CustomerTypeController.{id}");
        Mono<CustomerType> customerType = service.findById(id);
        return new ResponseEntity<Mono<CustomerType>>(customerType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<CustomerType>> insert(@RequestBody CustomerType obj){
    	
        Mono<CustomerType> customerType = service.insert(obj);
        return new ResponseEntity<Mono<CustomerType>>(customerType, HttpStatus.CREATED);
    }
	@PutMapping
	public ResponseEntity<Mono<CustomerType>> update(@RequestBody CustomerType obj){
		Mono<CustomerType> customerType = service.update(obj);
		return new ResponseEntity<Mono<CustomerType>>(customerType, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}