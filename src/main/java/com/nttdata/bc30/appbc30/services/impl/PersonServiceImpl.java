package com.nttdata.bc30.appbc30.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bc30.appbc30.models.documents.Person;
import com.nttdata.bc30.appbc30.models.repository.IPersonRepository;
import com.nttdata.bc30.appbc30.services.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository repo;
	
	@Override
	public Mono<Person> insert(Person obj) {
		return repo.insert(obj);
	}

	@Override
	public Mono<Person> update(Person obj) {
		return repo.save(obj);
	}

	@Override
	public Flux<Person> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Person> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<Void> delete(String id) {
		return repo.deleteById(id);
	}

}
