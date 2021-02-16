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

	//access AddressRepository for CRUD operations on Address
	@Autowired
	private AddressRepository repo; 


	//create a Address
	public Address createAddress(Address address) {
		return repo.save(address);
	}


	//update Address method
	public Address updateAddresss(Address address, Long address_id) throws Exception{
		try{
			Address oldAddress = repo.findOne(address_id);
			oldAddress.setStreet(address.getStreet());
			oldAddress.setCity(address.getCity());
			oldAddress.setState(address.getState());
			oldAddress.setZipcode(address.getZipcode());
			logger.info("Successfully updated the address with id " + address_id);
			return repo.save(oldAddress);
		}catch(Exception e){
			logger.error("Exception occurred while trying to update the address with id " + address_id, e);
			throw new Exception("Unable to update the address.");
		}
	}

}





































