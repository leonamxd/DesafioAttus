package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Person;
import com.project.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(Long _id) {
		return personRepository.findById(_id).get();
	}

	public Person save(Person _person) {
		return personRepository.save(_person);
	}
}
