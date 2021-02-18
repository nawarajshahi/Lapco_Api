package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nawarajshahi.Lapco.Entity.Address;
import com.nawarajshahi.Lapco.repository.AddressRepository;

import java.util.Set;


@Service
public class AddressService 
{
	
	private static final Logger logger = LogManager.getLogger(AddressService.class);

	private Long existingAddressId;

	//access AddressRepository for CRUD operations on Address
	@Autowired
	private AddressRepository repo;


	//create a Address
	public Address createAddress(Address address) {
		try{
			if(!doesAddressExist(address)){
				//creates and returns this new address
				logger.info("Did not find existing address with same values. Created new address instead");
				return repo.save(address);
			}
			//returns the existing address
			logger.info("Returning existing address with id: " + existingAddressId);
			return repo.findOne(existingAddressId);
		}catch (Exception e){
			logger.error("Exception occurred while creating address");
			throw e;
		}
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

	//private method to check if address exists in the database
	private boolean doesAddressExist(Address newAddress){
		Iterable<Address> addresses = repo.findAll();
		for(Address address: addresses){
			if(address.getStreet().equals(newAddress.getStreet()) &&
				address.getCity().equals(newAddress.getCity()) &&
					address.getState().equals(newAddress.getState()) &&
					address.getZipcode().equals(newAddress.getZipcode())){

				//if address exists then simply assign the the address_id to existingAddressId
				existingAddressId = address.getAddressId();
				return true;
			}
			return false;
		}
		return false;
	}

}





































