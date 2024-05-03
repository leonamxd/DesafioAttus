package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repositories.AdressRepository;

@Service
public class AdressService {

	@Autowired
	private AdressRepository adressRepository;
}
