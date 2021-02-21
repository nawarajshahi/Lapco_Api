package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.Entity.DoorSensor;
import com.nawarajshahi.Lapco.service.DoorSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restroom/{rest_id}/restrooms")
public class DoorSensorController {

    @Autowired
    private DoorSensorService doorSensorService;

    //create doorSensor read for given restroom_id
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createDoorRead(@PathVariable Long rest_id, @RequestBody DoorSensor doorSensor){

//        List<DoorSensor> doorSensors = doorSensorService.getDoorReadsByRestroomId(rest_id);
//        for (DoorSensor sensor: doorSensors){
//            System.out.println(sensor);
//        }
        return new ResponseEntity<>(doorSensorService.createDoorRead(rest_id, doorSensor), HttpStatus.CREATED);
    }

    /*
    //read all the door sensor reads for given restroom_id
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> readAllDoorReadsByRestroomId(@PathVariable Long rest_id){

    }

     */

}
