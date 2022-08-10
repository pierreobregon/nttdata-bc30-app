package com.nttdata.bc30.appbc30;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.nttdata.bc30.appbc30.models.documents.Contract;
import com.nttdata.bc30.appbc30.models.documents.Customer;
import com.nttdata.bc30.appbc30.models.documents.CustomerType;
import com.nttdata.bc30.appbc30.models.documents.Person;
import com.nttdata.bc30.appbc30.models.repository.ICustomerRepository;
import com.nttdata.bc30.appbc30.models.repository.ICustomerTypeRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class AppBc30Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(AppBc30Application.class);
	
	@Autowired
	private ICustomerTypeRepository customerTypeRepo;
	
	@Autowired
	private ICustomerRepository customerRepo ;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(AppBc30Application.class, args);
		log.info("main AppBc30Application");
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("customertypes").subscribe();
		mongoTemplate.dropCollection("customers").subscribe();
		
		Flux.just(new CustomerType(null,"Personal","Cliente Personal")
				)
		.flatMap(customerType -> {
			return customerTypeRepo.save(customerType);
			})
		.subscribe(customerType -> log.info("trace.."+customerType));
		
		Flux<CustomerType> customerTypeFlux =  customerTypeRepo.findAll();
		
		
		
		customerTypeFlux.subscribe(customerType -> {
					
							log.info("-------"+customerType);
							
							Flux.just(new Customer(null,
									customerType, 
										new Person("1","Pierre O","DNI","21548798",""),
										new ArrayList<Contract>(){
									          {
									        	  add(new Contract("1","00011023103",null, null, null,null));
									        	  add(new Contract("2","00022999999",null, null, null,null));
									          }
									        }
									)
									)
							.flatMap(customer -> {
								return customerRepo.save(customer);
								})
							.subscribe(customer -> log.info("trace.."+customer));
					}
				);
		
//		
//		.subscribe(customerType -> {
//			
//			
//			log.info("trace...");
//			
//			
//			Flux<CustomerType> fluxCustomerType = customerTypeRepo.findAll();
//			
//			
//			Flux.just(new Customer(null,
//					customerType, 
//						new Person("1","Pierre O","DNI","21548798",""),
//						new ArrayList<Contract>(){
//					          {
//					        	  add(new Contract("1","00011023103",null, null, null,null));
//					        	  add(new Contract("2","00022999999",null, null, null,null));
//					          }
//					        }
//					)
//					)
//			.flatMap(customer -> {
//				return customerRepo.save(customer);
//				})
//			.subscribe(customer -> log.info("trace.."+customer));;
//			
//			
//		});
		
		
		
	}

}
