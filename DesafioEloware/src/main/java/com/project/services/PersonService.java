package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepositpry;
}
