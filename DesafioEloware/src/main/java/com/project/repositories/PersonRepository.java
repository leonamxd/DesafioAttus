package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
