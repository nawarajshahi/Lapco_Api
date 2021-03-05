package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.Address;
import com.nawarajshahi.Lapco.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * currently AddressController is deactivated intentionally
 */
//@RestController
//@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService addService;

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

