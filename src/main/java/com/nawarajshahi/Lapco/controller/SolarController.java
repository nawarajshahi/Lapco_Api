package com.nawarajshahi.Lapco.controller;

import com.nawarajshahi.Lapco.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restroom/{rest_id}/solar")
public class SolarController {

    @Autowired
    private SolarService solarService;

    //read all the solar read info by restroom_id
    
}
