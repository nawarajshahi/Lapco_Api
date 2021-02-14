package com.nawarajshahi.Lapco.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawarajshahi.Lapco.Entity.Address;
import com.nawarajshahi.Lapco.repository.AddressRepository;



@Service
public class AddressService 
{
	
	private static final Logger logger = LogManager.getLogger(AddressService.class);
	
	@Autowired
	private AddressRepository repo; 
	
	//getAddressById method 
	public Address getAddressById(Long address_id) throws Exception{
		try {
			logger.info("successfully retrieved, address id: " + address_id);
			return repo.findOne(address_id);
		}catch(Exception e) {
			logger.error("Error retrieving the address with address_id: " + address_id);
			throw e;
		}
	}
	
	//get all Addresses method
	public Iterable<Address> getAddresses(){
		return repo.findAll();
	}
	
	

}
