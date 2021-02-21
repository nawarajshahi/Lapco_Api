package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.Entity.WaterBill;
import com.nawarajshahi.Lapco.service.WaterBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restroom/{rest_id}/waterBill")
public class WaterBillController {

    @Autowired
    private WaterBillService waterBillService;

    //create water bill read for given rest_id
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createWaterBillByRestroomId(@PathVariable Long rest_id, @RequestBody WaterBill waterBill) throws Exception {
        return new ResponseEntity<>(waterBillService.createWaterBillByRestroomId(rest_id, waterBill), HttpStatus.CREATED);
    }

    //read water bills for given rest_id
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getWaterBillsByRestroomId(@PathVariable Long rest_id){
        List<WaterBill> waterBills = waterBillService.getWaterBillsByRestroomId(rest_id);
        List<String> waterBillsToString = new ArrayList<>();
        for (WaterBill waterBill : waterBills) {
            waterBillsToString.add(waterBill.toString());
        }
        return new ResponseEntity<>(waterBillsToString, HttpStatus.OK);
    }

}
