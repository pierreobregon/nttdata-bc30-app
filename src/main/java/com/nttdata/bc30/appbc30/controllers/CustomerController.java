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

import com.nttdata.bc30.appbc30.AppBc30Application;
import com.nttdata.bc30.appbc30.models.documents.Customer;
import com.nttdata.bc30.appbc30.models.documents.CustomerType;
import com.nttdata.bc30.appbc30.services.ICustomerService;
import com.nttdata.bc30.appbc30.services.ICustomerTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/1.0.0/customers")
public class CustomerController {
	
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private ICustomerTypeService customerTypeService;
	
	@GetMapping
	public ResponseEntity<Flux<Customer>> findAll(){
		Flux<Customer> customers = service.findAll();
		return new ResponseEntity<Flux<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Customer>> fintById(@PathVariable("id") String id){
		Mono<Customer> customer = service.findById(id);
		return new ResponseEntity<Mono<Customer>>(customer, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Mono<Customer>> insert(@RequestBody Customer obj){
		if (obj.getCustomerType().getId()!=null) {
			//consulta objeto...repository
			Mono<CustomerType> cutomerTypeMono = customerTypeService.findById(obj.getCustomerType().getId());
			CustomerType customerTypeBD = null;
			
//			cutomerTypeMono.map(customerType ->{ 
//				return new CustomerType(customerType.getId(), customerType.getName(), customerType.getDescription());
//				}
//			 );
			
			cutomerTypeMono.map(customerType ->{ 
				return new CustomerType(customerType.getId(), customerType.getName(), customerType.getDescription());
				}
			 );
			
			
			log.info("cutomerTypeMono XXXXXX: "+ cutomerTypeMono);
			obj.setCustomerType(new CustomerType());
		}
		Mono<Customer> customer = service.insert(obj);
		return new ResponseEntity<Mono<Customer>>(customer, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Mono<Customer>> update(@RequestBody Customer obj){
		Mono<Customer> customer = service.update(obj);
		return new ResponseEntity<Mono<Customer>>(customer, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		service.delete(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
}
