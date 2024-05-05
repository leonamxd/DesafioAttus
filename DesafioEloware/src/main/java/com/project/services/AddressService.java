package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Address;
import com.project.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address findById(Long id) {
		return addressRepository.findById(id).get();
	}

	public Address save(Address adress) {
		return addressRepository.save(adress);
	}

	public List<Address> findByPersonId(Long personId) {
		 return addressRepository.findByPersonId(personId);
	}
}
