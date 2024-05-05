package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Person;
import com.project.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> findAll(){
		
		List<Person> personResult = personService.findAll();
		
		return personResult;
	}
	
	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable Long id){
		
		Person personResult = personService.findById(id);
		
		return personResult;
	}
	
	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		
		Person personResult = personService.save(person);
		
		return personResult;
	}
	
	@PutMapping("/{personId}/edit")
	public ResponseEntity<String> updatePerson(@PathVariable Long personId, 
											   @RequestBody Person updatedPerson) {
		
	    Person person = personService.findById(personId);

	    person.setName(updatedPerson.getName());
	    person.setBirth(updatedPerson.getBirth());

	    personService.save(person);

	    return ResponseEntity.ok("Pessoa atualizada com sucesso!");
	}
}
