package com.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String zip;
	private String number;
	private String city;
	private String uf;
	private boolean principal_address;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;



	public Address() {
		
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zip;
	}
	public void setZipCode(String zip) {
		this.zip = zip;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public boolean isPrincipalAddress() {
		return principal_address;
	}
	public void setPrincipalAddress(boolean principal_address) {
		this.principal_address = principal_address;
	}
}
