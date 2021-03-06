package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.DoorSensor;
import com.nawarajshahi.Lapco.service.DoorSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DoorSensorController {

    @Autowired
    private DoorSensorService doorSensorService;

    //create doorSensor read for given restroom_id
    @RequestMapping(value = "/restroom/{rest_id}/door",method = RequestMethod.POST)
    public ResponseEntity<?> createDoorRead(@PathVariable Long rest_id, @RequestBody DoorSensor doorSensor){
        try{
            return new ResponseEntity<>(doorSensorService.createDoorRead(rest_id, doorSensor), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
