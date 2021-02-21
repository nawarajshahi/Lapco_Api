package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.service.CoinSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restroom/{rest_id}/coinReads")
public class CoinSensorController {

    @Autowired
    private CoinSensorService coinService;

    //create new coin reads for given rest_id
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Object> createCoinRead(@RequestBody CoinSensor coinSensor){
//        return new ResponseEntity<>(coinService.createCoinRead(coinSensor), HttpStatus.CREATED);
//    }

    //get all coin reads for given rest_id
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCoinSensorDetailsByRestroomId(@PathVariable Long rest_id){
        try{
            List<CoinSensor> coinSensors = coinService.getReadsByRestroomId(rest_id);
            List<String> coinSensorsToString = new ArrayList<>();
            for (CoinSensor coinSensor:coinSensors) {
                coinSensorsToString.add(coinSensor.toString());
            }
            return new ResponseEntity<>(coinSensorsToString, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
