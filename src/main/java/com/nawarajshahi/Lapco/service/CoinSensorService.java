package com.nawarajshahi.Lapco.service;

import com.nawarajshahi.Lapco.Entity.CoinSensor;
import com.nawarajshahi.Lapco.Entity.Restroom;
import com.nawarajshahi.Lapco.repository.CoinSensorRepository;
import com.nawarajshahi.Lapco.repository.RestroomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoinSensorService implements Serializable {

    private static final Logger logger = LogManager.getLogger(CoinSensorService.class);

    //access CoinSensorRepository to perform CRUD operations on CoinSensor
    @Autowired
    private CoinSensorRepository coinRepo;

    @Autowired
    private RestroomRepository restRepo;


    public List<CoinSensor> getReadsByRestroomId(Long rest_id){

        List<CoinSensor> coinSensors = new ArrayList<>();

        Iterable<CoinSensor> coinSensorIterable = coinRepo.findAll();
        for (CoinSensor coinSensor : coinSensorIterable) {
            if(coinSensor.getRestroom().getRestroomId() == rest_id){
                coinSensors.add(coinSensor);
            }
        }
        return coinSensors;
    }

}
