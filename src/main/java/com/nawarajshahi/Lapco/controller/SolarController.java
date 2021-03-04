package com.nawarajshahi.Lapco.controller;


import com.nawarajshahi.Lapco.Entity.Solar;
import com.nawarajshahi.Lapco.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solars")
public class SolarController {

    @Autowired
    private SolarService solarService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createSolarRead(@RequestBody Solar solar, Long[] restroomIds) throws Exception {
        return new ResponseEntity<>(solarService.createSolarRead(solar, restroomIds), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{read_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRestroomsBySolarReadId(@PathVariable Long read_id){
        return new ResponseEntity<>(solarService.restroomsCoveredBySolarReadId(read_id), HttpStatus.OK);
    }
    
}
