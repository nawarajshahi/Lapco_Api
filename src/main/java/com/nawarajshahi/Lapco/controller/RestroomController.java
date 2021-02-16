package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.service.RestroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;

@Controller
@RequestMapping(value = "/restroom")
public class RestroomController {

    @Autowired
    private RestroomService restroomService;

    //get restroom information by restroom_id
    @RequestMapping(value ="/{rest_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getRestroomDetailById(@PathVariable Long rest_id){
        try{
            return new ResponseEntity<>(restroomService.getRestroomDetailById(rest_id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //get restroom details for all the restroom units
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllRestroom(){
        return new ResponseEntity<>(restroomService.getRestroomDetails(), HttpStatus.OK);
    }

    //create new restroom
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewRestroom(@RequestBody Restroom restroom) throws Exception{
        try{
            return new ResponseEntity<>(restroomService.createRestroom(restroom), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //update restroom by restroom_id
    @RequestMapping(value = "/{rest_id", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateRestroomById(@RequestBody Restroom restroom, @PathVariable Long rest_id){
        try{
            return new ResponseEntity<>(restroomService.updateRestroom(restroom, rest_id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //delete restroom by restroom_id
    @RequestMapping(value = "/{rest_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRestroomById(@PathVariable Long rest_id){
        try{
            restroomService.deleteRestroom(rest_id);
            return new ResponseEntity<>("Successfully deleted the restroom with id " + rest_id, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

































