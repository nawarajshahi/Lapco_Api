package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.ElectricBill;
import com.nawarajshahi.Lapco.service.ElectricBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restroom/{rest_id}/electricBill")
public class ElectricBillController {

    @Autowired
    private ElectricBillService electricService;

    // create electric bill for given rest_id
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createElectricBill(@PathVariable Long rest_id, @RequestBody ElectricBill electricBill){
        try{
            return new ResponseEntity<>(electricService.createElectricBill(rest_id, electricBill), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
