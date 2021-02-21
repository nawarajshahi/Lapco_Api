package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.Entity.DoorSensor;
import com.nawarajshahi.Lapco.service.DoorSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restroom/{rest_id}/restrooms")
public class DoorSensorController {

    @Autowired
    DoorSensorService doorSensorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createDoorRead(@PathVariable Long rest_id, @RequestBody DoorSensor doorSensor){
        return new ResponseEntity<>(doorSensorService.createDoorRead(rest_id, doorSensor), HttpStatus.CREATED);
    }
}
