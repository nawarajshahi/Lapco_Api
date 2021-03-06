package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.service.CoinSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restroom/{rest_id}/coinReads")
public class CoinSensorController {

    @Autowired
    private CoinSensorService coinService;

    //create new coin reads for given rest_id
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCoinRead(@PathVariable("rest_id") Long rest_id, @RequestBody CoinSensor coinSensor){
       try{
           return new ResponseEntity<>(coinService.createCoinRead(rest_id, coinSensor), HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
       }
    }

}
