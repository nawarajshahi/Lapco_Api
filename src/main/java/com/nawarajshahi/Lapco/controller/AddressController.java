package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.Address;
import com.nawarajshahi.Lapco.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addService;

    //access an address with address id
    @RequestMapping(value = "/{add_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAddress(@PathVariable Long add_id){
        try{
            return new ResponseEntity<>(addService.getAddressById(add_id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //access all addresses
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllAddresses(){
        return new ResponseEntity<>(addService.getAddresses(), HttpStatus.OK);
    }

    //create an address
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> createAddress(@RequestBody Address address){
        return new ResponseEntity<>(addService.createAddress(address), HttpStatus.CREATED);
    }

    //update an address by address id
    @RequestMapping(value ="/{add_id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAddress(@RequestBody Address address, @PathVariable Long add_id){
        try{
            return new ResponseEntity<>(addService.updateAddresss(address, add_id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //delete a address by address id
    @RequestMapping(value = "/{add_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAddress(@PathVariable Long add_id){
        try{
            addService.deleteAddress(add_id);
            return new ResponseEntity<>("Successfully deleted the address", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}



























