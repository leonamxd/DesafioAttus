package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Address;
import com.project.models.Person;
import com.project.services.AddressService;
import com.project.services.PersonService;

@RestController
@RequestMapping(value = "/associte")
public class AddressPersonController {

	
	@Autowired 
	private PersonService personService;
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/{personId}")
	public Address saveAddressInPerson(@RequestBody Address address, 
									   @PathVariable Long personId) {
		
		Person person = personService.findById(personId);
		address.setPerson(person);
		
		Address addressResult = addressService.save(address);
		
		return addressResult;
	}
	
	@PostMapping("/{personId}/{addressId}")
	public ResponseEntity<String> associateAdressToPerson(@PathVariable Long personId,
														  @PathVariable Long addressId) {
		
	    Person person = personService.findById(personId);
	    Address address = addressService.findById(addressId);

	    address.setPerson(person);
	    addressService.save(address);

	    return ResponseEntity.ok("Endereço associado à pessoa com sucesso!");
	}

	@PutMapping("/{personId}/{addressId}/markAsPrincipal")
	public ResponseEntity<String> markAddressAsPrimary(@PathVariable Long personId,
													   @PathVariable Long addressId) {
		
	    List<Address> addresses = addressService.findByPersonId(personId);
	    
	    for (Address a : addresses) {
	        if (a.getId().equals(addressId)) {
	            a.setPrincipalAddress(true);
	        } else {
	            a.setPrincipalAddress(false);
	        }
	        addressService.save(a);
	    }

	    return ResponseEntity.ok("Endereço marcado como principal com sucesso!");
	}
}
