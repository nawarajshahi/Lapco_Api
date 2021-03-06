package com.nawarajshahi.Lapco.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Address implements Serializable {


	private Long addressId;
	private String street;
	private String city;
	private String state;
	private String zipcode;


	private Set<Restroom> restrooms = new HashSet<Restroom>(0);

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

	@Override
	public String toString() {
		return 	"addressId: " + addressId +
				", street: " + street +
				", city: " + city +
				", state: " + state +
				", zipcode: " + zipcode;
	}
}
