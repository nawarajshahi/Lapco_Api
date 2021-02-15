package com.nawarajshahi.Lapco.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address", catalog = "lapco_api")
public class Address{

	private Long addressId;
	private String street;
	private String city;
	private String state;
	private String zipcode;

	@JsonIgnore
	private Set<Restroom> restrooms = new HashSet<Restroom>(0);

	public Address() {
	}
	
	public Address(Long addressId, String street, String city, String state, String zipcode, Set<Restroom> restrooms) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.restrooms = restrooms;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "address_id", unique = true, nullable = false)
	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	@Column(name = "Street", length = 100)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "City", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "State", length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zipcode", length = 11)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Restroom> getRestrooms() {
		return this.restrooms;
	}

	public void setRestrooms(Set<Restroom> restrooms) {
		this.restrooms = restrooms;
	}


}
