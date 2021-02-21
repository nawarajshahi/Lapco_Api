package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.service.CoinSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/restroom/{rest_id}/CoinSensor")
public class CoinSensorController {


    @Autowired
    private CoinSensorService coinService;

    /*
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCoinSensorDetailsByRestroomId(@PathVariable Long rest_id){
        try{
            return new ResponseEntity<>(coinService.getSensorsByRestroomId(rest_id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

     */



    /*

    //get coin_read by read_id
    @RequestMapping(value = "/{read_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCoinReadById(@PathVariable Long read_id){
        try{
            return new ResponseEntity<>(coinService.getCoinSensorByReadId(read_id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //create new coin_read
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createCoinRead(@RequestBody CoinSensor coinSensor){
        return new ResponseEntity<>(coinService.createCoinRead(coinSensor), HttpStatus.CREATED);
    }

    //read all coin_reads from the coinSensor



     */

}
