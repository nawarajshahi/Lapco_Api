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

	//delete a address
	public void deleteAddress(Long add_id) throws Exception{
		try{
			repo.delete(add_id);
			logger.info("Successfully deleted the address with id: " + add_id);
		}catch(Exception e){
			logger.error("Exception occurred while trying to delete the address with id: " + add_id, e);
			throw e;
		}
	}

}





































