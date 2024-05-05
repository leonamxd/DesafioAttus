package com.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByPersonId(Long personId);

}
