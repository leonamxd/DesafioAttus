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

import com.project.models.Address;
import com.project.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping
	public List<Address> findAll() {
		
		List<Address> addressResult = addressService.findAll();
		
		return addressResult;
	}

	@GetMapping(value = "/{id}")
	public Address findAById(@PathVariable Long id) {
		
		Address addressResult = addressService.findById(id);
		
		return addressResult;
	}

	@PostMapping
	public Address saveAdress(@RequestBody Address address) {
		
		Address addressResult = addressService.save(address);
		
		return addressResult;
	}
	
	@PutMapping("/{addressId}/edit")
	public ResponseEntity<String> updateAddress(@PathVariable Long addressId, 
											   @RequestBody Address updatedAddress) {
		
	    Address address = addressService.findById(addressId);
	    
	    address.setStreet(updatedAddress.getStreet());
	    address.setZipCode(updatedAddress.getZipCode());
	    address.setNumber(updatedAddress.getNumber());
	    address.setCity(updatedAddress.getCity());
	    address.setUf(updatedAddress.getUf());

	    addressService.save(address);
	    
	    return ResponseEntity.ok("Endereço atualizado com sucesso!");
	}
}
